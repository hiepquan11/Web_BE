package com.huynhduc.WebBE.Service.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceIpml implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void SendMessage(String from, String to, String subject, String text) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        // sending email
        mailSender.send(message);
    }
}
