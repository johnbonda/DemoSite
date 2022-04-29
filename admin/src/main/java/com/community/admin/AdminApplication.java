package com.community.admin;

import java.util.Properties;

import org.broadleafcommerce.common.config.EnableBroadleafAdminAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@EnableAutoConfiguration
public class AdminApplication {

    @Configuration
    @EnableBroadleafAdminAutoConfiguration
    public static class BroadleafFrameworkConfiguration {}

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
    
    @Bean
    public JavaMailSender blMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("localhost");
        sender.setPort(30000);
        sender.setProtocol("smtp");
        sender.setUsername("");
        sender.setPassword("");
        Properties javaMailProps = new Properties();
        javaMailProps.setProperty("mail.smtp.starttls.enable", "true");
        javaMailProps.setProperty("mail.smtp.auth", "true");
        javaMailProps.setProperty("mail.smtp.timeout", "25000");
        sender.setJavaMailProperties(javaMailProps);
        return sender;
    }
    
   
 
}
