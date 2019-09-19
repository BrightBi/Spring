package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.independent.event.ActiveEvent;
import bimingliang.independent.mail.SpringMail;
import bimingliang.independent.properties.Properties;
import bimingliang.independent.relation.ForRelation;
import bimingliang.independent.task.SpringTask;
import bimingliang.independent.util.Util;

public class Independent06 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Independent.xml");
		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("************************* Event *************************");
		ActiveEvent activeEvent = (ActiveEvent) ctx.getBean("activeEvent");
		activeEvent.activeEvent();
		
		System.out.println("************************* Util *************************");
		Util util = (Util) ctx.getBean("util");
		System.out.println(util.getList().get(0));
		System.out.println(util.getSet().size());
		System.out.println(util.getMap().get("key_1"));
		
		System.out.println("************************* Mail *************************");
		SpringMail springMail = (SpringMail) ctx.getBean("springMail");
		System.out.println(springMail.hashCode());
		// springMail.sendSimpleMail();
		// springMail.sendMimeMail();
		// springMail.sendHtmlMail();
		
		System.out.println("************************* Properties *************************");
		Properties properties = (Properties) ctx.getBean("properties");
		properties.detail();
		properties.getPropertiesJava().detail();
		
		System.out.println("************************* Relation *************************");
		ForRelation relationFirst = (ForRelation) ctx.getBean("relationFirst");
		relationFirst.detail();
		ForRelation relationSecond = (ForRelation) ctx.getBean("relationSecond");
		relationSecond.detail();
		ForRelation relationDepend = (ForRelation) ctx.getBean("relationDepend");
		relationDepend.detail();
		
		System.out.println("************************* Task *************************");
		// 直接启动就可以了，@Scheduled任务会自动参与调度
		SpringTask springTask = (SpringTask) ctx.getBean("springTask");
		springTask.taskAsync();
	}
}
