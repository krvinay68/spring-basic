package com.krvinay.fielddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	@Qualifier("emailService")
	private MessageService messageService;
	
	@Autowired
	private SMSService sMSService;
	
	public void sendMessage(String message) {
		
		this.messageService.sendMessage(message);
		this.sMSService.sendMessage(message);
	}
}
