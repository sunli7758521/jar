package com.start;

import io.xjar.XEntryFilter;
import io.xjar.XKit;
import io.xjar.boot.XBoot;
import io.xjar.jar.XJarAntEntryFilter;
import io.xjar.jar.XJarRegexEntryFilter;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;

import java.io.File;

/**
 *        sunli
 * @data 2019/6/5
 *   jar   加密
 */
public class Encrypt {
    // https://blog.csdn.net/ChangeYoung1921/article/details/84621787
    // Spring-Boot Jar包加密
//    public static void main(String[] args) throws Exception {
//        String password = "io.xjar";
//                                            // jar 包地址
//        File plaintext = new File("D:/bluebird-3.0.jar");
//                                            // 加密后jar存放地址
//        File encrypted = new File("D:/path/bluebird-3.0.jar");
//        XBoot.encrypt(plaintext, encrypted, password);
//    }
//
//    // Spring-Boot Jar包解密
//    public static void main(String[] args) {
//        String password = "io.xjar";
//        File encrypted = new File("/path/to/read/encrypted.jar");
//        File decrypted = new File("/path/to/save/decrypted.jar");
//        XBoot.decrypt(encrypted, decrypted, password);
//    }
//
//    // Jar包加密
//    public static void main(String[] args) {
//        String password = "io.xjar";
//        File plaintext = new File("/path/to/read/plaintext.jar");
//        File encrypted = new File("/path/to/save/encrypted.jar");
//        XJar.encrypt(plaintext, encrypted, password);
//    }
//    // Jar包解密
//    public static void main(String[] args) {
//        String password = "io.xjar";
//        File encrypted = new File("/path/to/read/encrypted.jar");
//        File decrypted = new File("/path/to/save/decrypted.jar");
//        XJar.decrypt(encrypted, decrypted, password);
//    }
//    命令行运行JAR
//    java -jar /path/to/encrypted.jar
//    在提示输入密码的时候输入密码后按回车即可正常启动，也可以通过传参的方式直接启动
//    java*/ -jar /path/to/encrypted.jar --xjar.password=PASSWORD


    // 只加密自身项目及相关模块的源码不加密第三方依赖，可以通过XJarArchiveEntryFilter来定制需要加密的JAR包内资源
    public static void main(String[] args) throws Exception {
        String password = "passwordsunli";
        /** 一次加密*/
//        File plaintext = new File("F:/bluebird-3.0.jar");
//        File encrypted = new File("F:/aa/bluebird-3.0.jar");

//        File plaintext = new File("D:\\workspace\\blue_admin\\server\\ruoyi-admin\\target\\bluebird-3.0.jar");
//        File encrypted = new File("F:/aa/bluebird-3.0.jar");
        File plaintext = new File("D:\\workspace\\blue_bird\\client\\blue_admin\\target\\blue_admin-1.0-SNAPSHOT.jar");
        File encrypted = new File("F:/aa/blue_admin-1.0-SNAPSHOT.jar");

//        /** 二次加密*/
//        File plaintext = new File("F:/bluebird-3.0.jar");
//        File encrypted = new File("F:/aa/bluebird-3.0.jar");
        /** 一次加密*/
//        XBoot.encrypt(plaintext, encrypted, password, new XJarAntEntryFilter("com/ruoyi/**"));
//        XBoot.encrypt(plaintext, encrypted, password, new XJarAntEntryFilter("*.yml"));
        XBoot.encrypt(plaintext, encrypted, password, new XEntryFilter<JarArchiveEntry>() {
            public boolean filtrate(JarArchiveEntry entry) {
                return  entry.getName().equalsIgnoreCase("application-test.yml") ||
//                        entry.getName().equalsIgnoreCase("application-druid.yml") ||
                        entry.getName().equalsIgnoreCase("application-pro.yml") ||
                        entry.getName().equalsIgnoreCase("application-dev.yml") ||
                        entry.getName().equalsIgnoreCase("application.yml") ||
                        entry.getName().startsWith("com/") ;
//                 entry.getName().startsWith("com/msj/goods/") ;
            }
        });


    }

}
