package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import conf.JavaConfigPrototype;
import spring.Client;
import spring.Client2;

public class MainPrototype2 {

	public static void main(String[] args) {
		useXml();
		userJava();
	}

	private static void userJava() {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		Client2 client1 = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		
		System.out.println("Java 설정 prototype : (client1 != client2) -> " + (client1 != client2));
		
		try {
			client1.close();
			client2.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ctx.close();
		
	}

	private static void useXml() {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:springConfPrototype.xml");
		Client client1 = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		
		System.out.println("xml 설정 prototype : (client1 != client2) -> " + (client1 != client2));
		
		try {
			client1.destroy();
			client2.destroy();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ctx.close();
	}
	
}
