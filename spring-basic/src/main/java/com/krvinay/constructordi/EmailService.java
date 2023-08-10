package com.krvinay.constructordi;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService{

	@Override
	public void sendMessage(String message) {
		System.out.println(message);
	}

}
