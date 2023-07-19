package com.etc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zwh
 * @date 2021/11/17
 * 书架项目启动类
 */
@SpringBootApplication
@MapperScan("com.etc.dao")
public class BookShopApplictation {
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplictation.class,args);
    }
}
