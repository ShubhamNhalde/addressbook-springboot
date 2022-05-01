package com.bridgelabz.addressbook.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nhaldes@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        sender.send(message);
        System.out.println("Mail sent to the User...!");
    }
}
