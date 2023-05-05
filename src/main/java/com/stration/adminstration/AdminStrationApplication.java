package com.stration.adminstration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stration.adminstration.generator.mapper")
public class AdminStrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminStrationApplication.class, args);
    }

}
