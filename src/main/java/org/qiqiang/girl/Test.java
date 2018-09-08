package org.qiqiang.girl;


import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("Java将字符串转化为hash值".hashCode()%50);
    }
}
