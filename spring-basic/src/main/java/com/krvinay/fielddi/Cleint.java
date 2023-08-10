package com.krvinay.fielddi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cleint {
	
	
	public static void main(String []args) {
	String message="Hi!! GOOD MORNIG .....This is example of Field Injection";
	ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	
	MessageSender sender=context.getBean(MessageSender.class);
	sender.sendMessage(message);
	}
}
