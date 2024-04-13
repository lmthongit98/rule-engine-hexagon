package com.project.ruleengine.application.port.out;

import com.project.ruleengine.application.dtos.email.EmailRequestDto;

public interface EmailService {
    void sendEmail(EmailRequestDto emailRequestDto);
}
