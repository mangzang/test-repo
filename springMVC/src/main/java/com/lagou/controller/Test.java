package com.lagou.controller;

import java.io.File;

public class Test {

    public static void main(String[] args) {


        File file = new File("E:\\", "a.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        System.out.println(file.getParentFile().getAbsolutePath());


    }

}
