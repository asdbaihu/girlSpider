package org.qiqiang.girl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.net.URL;

public class ImagePipeline implements Pipeline {
    public void process(ResultItems resultItems, Task task) {
        String url = resultItems.get("url").toString();
        if (StringUtils.isBlank(url)) {
            return;
        }
        String title = resultItems.get("title").toString();
        String name = StringUtils.substring(url, StringUtils.lastIndexOf(url, "/") + 1);
        int group = title.hashCode() % 100;
        System.out.println("正在下载：" + url);
        try {
            String path = "C:\\Users\\kimi\\Desktop\\girl\\" + group + "\\" + title + "\\" + name;
            File file = new File(path);
            if (file.exists()) {
                System.out.println(path + "文件已存在");
                return;
            }
            FileUtils.copyURLToFile(new URL(url), file);
            System.out.println(path + "下载完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
