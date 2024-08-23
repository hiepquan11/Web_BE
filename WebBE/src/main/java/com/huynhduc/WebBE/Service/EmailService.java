package com.huynhduc.WebBE.Service;

public interface EmailService {
    public void SendMessage(String from ,String to, String subject, String text);
}
