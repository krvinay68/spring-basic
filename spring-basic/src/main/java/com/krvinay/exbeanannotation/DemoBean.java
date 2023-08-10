package com.krvinay.exbeanannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
	private Address address;
	
	public Student(Address address) {
		this.address= address;
	}
	public void print() {		
		System.out.println("Student class methd called.....");
		address.print();
	}	
	
	public void init() {
		System.out.println("initialization logic.....");
	}
	
	public void destroy() {
		System.out.println("destruction logic.....");
	}
}

class Address{
	public void print() {
		System.out.println("Address class methd called.....");
	}
}

@Configuration
class AppConfig{
	
	@Bean(name="addressBean")
	public Address address() {
		return new Address();
	}
	@Bean(name="studentBean", initMethod="init", destroyMethod="destroy")
	//@Bean(name={"studentBean","studentBean2"})//specify multiple names for same bean
	public Student student() {
		return new Student(address());
	}
}

public class DemoBean {
	public static void main(String []args) {
		
		/*ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		//Student student=context.getBean(Student.class);
		Student student=(Student) context.getBean("studentBean");
		String []beanNames=context.getBeanDefinitionNames();
		
		for(String names :beanNames) {
			
			System.out.println(names);
		}
		student.print();*/
		
		
		//Try with resources to close the ApplicationContext
		try(var context=new AnnotationConfigApplicationContext(AppConfig.class)){
			//Student student=context.getBean(Student.class);
			Student student=(Student) context.getBean("studentBean");
			String []beanNames=context.getBeanDefinitionNames();
			
			for(String names :beanNames) {
				
				System.out.println(names);
			}
			student.print();
		}
		
	}
}
