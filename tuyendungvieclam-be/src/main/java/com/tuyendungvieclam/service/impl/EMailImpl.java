package com.tuyendungvieclam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tuyendungvieclam.service.EMail;

@Service
public class EMailImpl implements EMail {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(String toEmail, String subject, String message) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(toEmail);
		simpleMessage.setSubject(subject);
		simpleMessage.setText(message);
		
		javaMailSender.send(simpleMessage);
	}
}