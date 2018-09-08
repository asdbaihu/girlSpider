package org.qiqiang.girl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        FileUtils.copyURLToFile(new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536399136834&di=43f19c30790d319af853057dff5bd704&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0dd7912397dda1449dd17697bfb7d0a20cf4863e.jpg"),new File("C:\\Users\\kimi\\Desktop\\test.jpg"));
    }
}
