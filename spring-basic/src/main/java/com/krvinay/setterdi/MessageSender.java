package com.krvinay.setterdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	private MessageService messageService;
	private SMSService sMSService;
	
	@Autowired
	public void setMessageService(@Qualifier("emailService") MessageService messageService) {
		this.messageService = messageService;
		System.out.println("setter injection 1");
	}

	@Autowired
	public void setsMSService(SMSService sMSService) {
		this.sMSService = sMSService;
		System.out.println("setter injection 2");
	}


	public void sendMessage(String message) {
		
		this.messageService.sendMessage(message);
		this.sMSService.sendMessage(message);
	}
}
