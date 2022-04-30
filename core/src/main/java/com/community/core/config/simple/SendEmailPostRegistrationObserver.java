package com.community.core.config.simple;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.core.service.listener.PostRegistrationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

@Component
public class SendEmailPostRegistrationObserver implements PostRegistrationObserver {

    @Resource(name = "blCustomerService")
    private CustomerService customerService;

    private JavaMailSender sender;

    @PostConstruct
    protected void init() {
        System.out.println("Registering email config");
        customerService.addPostRegisterListener(this);
    }

    public SendEmailPostRegistrationObserver() {
        this.sender = getJavaMailSender();
    }

    @Override
    public void processRegistrationEvent(Customer customer) {
        System.out.println("Sending email to " + customer.getEmailAddress());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("veerendra.surath034@gmail.com");
        message.setTo(customer.getEmailAddress());
        message.setSubject("Thank you for choosing our domain");
        message.setText("Your order is confirmed");
        sender.send(message);
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("john.bond629@gmail.com");
        mailSender.setPassword("password");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
