package com.yuanpeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 日志使用:SpringBoot底层也是使用slf4j+logback的方式进行日志记录
 */
@SpringBootApplication

@EnableTransactionManagement
public class CustomerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManageApplication.class, args);
    }

}
