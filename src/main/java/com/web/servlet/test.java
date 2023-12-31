package com.web.servlet;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File file = new File(""); // 创建空字符串表示当前目录
        String path = file.getAbsolutePath(); // 获取当前路径的绝对路径
        System.out.println(path);
    }
}
