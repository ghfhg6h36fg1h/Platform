package com.liangxin.platform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|{}");
    }
}