package org.qiqiang.girl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class GirlPageProcessor implements PageProcessor {
    /**
     * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     *
     * @param page
     */
    public void process(Page page) {
        //专辑页
        List<String> urls = page.getHtml().links().regex("http://www\\.27270\\.com/ent/meinvtupian/\\d+/\\w+\\.html").all();
        String articleV4BodyString = page.getHtml().css("div.articleV4Body").toString();
        if (StringUtils.isNotBlank(articleV4BodyString)){
            Document meinvTuPianBox = Jsoup.parse(articleV4BodyString);
            Elements img = meinvTuPianBox.getElementsByTag("p").get(0).getElementsByTag("img");
            String url = img.attr("src");
            String title = img.attr("alt");
            page.putField("title", title);
            page.putField("url", url);
        }
        page.addTargetRequests(urls);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GirlPageProcessor())
                //美女图片首页
                .addUrl("http://www.27270.com/ent/meinvtupian/")
                .addPipeline(new ImagePipeline())
                //开启十个线程
                .thread(10)
                .run();
    }
}
