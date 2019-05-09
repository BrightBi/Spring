package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.jms.ReceiveMessageService;
import bimingliang.jms.SendMessageServiceImplement;

public class TestJMS {

	public static void main(String[] args) {
		normalJMS();
		//listenerJMS();
	}
	
	public static void listenerJMS() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("*************************Listener JMS*************************");

		SendMessageServiceImplement sendMessageServiceImplement = (SendMessageServiceImplement) ctx.getBean("sendMessageServiceImplement");
		sendMessageServiceImplement.sendMessage("test.listener.jms", "JMS Listener Message Test1");
		sendMessageServiceImplement.sendMessage("destination", "JMS Message1");
		sendMessageServiceImplement.sendMessage("test.listener.jms", "JMS Listener Message Test2");
		sendMessageServiceImplement.sendMessage("destination", "JMS Message2");
		sendMessageServiceImplement.sendMessage("test.listener.jms", "JMS Listener Message Test3");
	}
	
	public static void normalJMS() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("*************************Normal JMS*************************");

		SendMessageServiceImplement sendMessageServiceImplement = (SendMessageServiceImplement) ctx.getBean("sendMessageServiceImplement");
		ReceiveMessageService receiveMessageService = (ReceiveMessageService) ctx.getBean("receiveMessageService");
		
		sendMessageServiceImplement.sendMessage("destination", "JMS Message");
		System.out.println(receiveMessageService.receiveMessage("destination"));
	}

}
