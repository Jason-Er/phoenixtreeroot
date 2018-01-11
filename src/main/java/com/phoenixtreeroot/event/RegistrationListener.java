package com.phoenixtreeroot.event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.phoenixtreeroot.model.system.User;
import com.phoenixtreeroot.service.UserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent>{
	@Autowired
    UserService service;

    @Autowired
    MessageSource messages;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    Environment env;

    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.user;
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        final SimpleMailMessage email = constructEmailMessage(event, user, token);
        mailSender.send(email);
    }

    //

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        final String recipientAddress = user.email;
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.appUrl + "/registrationConfirm.html?token=" + token;
        // final String message = messages.getMessage("message.regSucc", null, event.locale);
        final String message = "confirm url";
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}