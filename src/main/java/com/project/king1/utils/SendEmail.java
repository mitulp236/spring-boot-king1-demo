package com.project.king1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class SendEmail {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String message,String subject,String reciver) {
		
		Runnable emailObj = new Runnable() 
		{
			@Override
			public void run() {
				SimpleMailMessage msg = new SimpleMailMessage();
			    msg.setTo(reciver);
			    msg.setSubject(subject);
			    msg.setText(message);
			    javaMailSender.send(msg);
			}
		};
		Thread emailThread = new Thread(emailObj);
		emailThread.start();
	}
}
