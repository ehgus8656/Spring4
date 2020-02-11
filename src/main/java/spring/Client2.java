package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2{
	
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		
		System.out.println("Client2.setHost() 실행");
	}
	
	public void connect() throws Exception {
		System.out.println("Client2.afterPropertiesSet() 실행");
	}
	
	public void send() {
		System.out.println("Client2.send() to " + host);
	}
	public void close() throws Exception{
		System.out.println("Client2.destroy() 실행");
	}
	
}
