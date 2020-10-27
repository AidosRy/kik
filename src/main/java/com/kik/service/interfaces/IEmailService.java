package com.kik.service.interfaces;

import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {

    void sendEmail(SimpleMailMessage email);
}
