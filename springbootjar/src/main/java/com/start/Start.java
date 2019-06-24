package com.start;

import io.xjar.boot.XBoot;

import java.io.File;

public class Start {

    // Spring-Boot Jar包加密
    public static void main(String[] args) throws Exception {
        String password = "io.xjar";
        File plaintext = new File("D:/bluebird-3.0.jar");
        File encrypted = new File("D:/path/bluebird-3.0.jar");
        XBoot.encrypt(plaintext, encrypted, password);
    }

}
