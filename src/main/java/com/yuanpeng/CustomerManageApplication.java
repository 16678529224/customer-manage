package com.yuanpeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志使用:SpringBoot底层也是使用slf4j+logback的方式进行日志记录
 */
@SpringBootApplication
public class CustomerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManageApplication.class, args);
    }

}
