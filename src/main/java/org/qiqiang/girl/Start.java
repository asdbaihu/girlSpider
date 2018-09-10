package org.qiqiang.girl;

import us.codecraft.webmagic.Spider;

/**
 * @author qiqiang
 * @Description
 * @date 2018-09-10
 */
public class Start {
    public static void main(String[] args) {
        Properties.path = args[1];
        Spider.create(new GirlPageProcessor())
                //美女图片首页
                .addUrl("http://www.27270.com/ent/meinvtupian/")
                .addPipeline(new ImagePipeline())
                //开启十个线程
                .thread(Integer.valueOf(args[0]))
                .run();
    }
}
