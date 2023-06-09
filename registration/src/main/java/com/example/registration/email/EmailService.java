package com.example.registration.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{
    private final static Logger LOGGER= LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender javaMailSender;
    @Override
    @Async
    public void send(String to, String email) {
    try{
        MimeMessage mimeMessage=javaMailSender.createMimeMessage(); //The MimeMessage class is used to create, read, and modify email messages with MIME content.
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"utf-8");
        helper.setText(email,true);
        helper.setTo(to);
        helper.setSubject("Confirm your email");
        helper.setFrom("hello@giorgos.com");
        javaMailSender.send(mimeMessage);
    }catch (MessagingException e){
        LOGGER.error("fail to send email");
        throw new IllegalStateException("failed to send email");
    }
    }
}
