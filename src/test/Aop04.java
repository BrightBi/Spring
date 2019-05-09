package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.aop.Base;
import bimingliang.aop.Bird;
import bimingliang.aop.Car;
import bimingliang.aop.Extend;
import bimingliang.aop.ForExtend;

public class Aop04 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Aop.xml");

		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("************************* CreateByName *************************");

		Car car = (Car) ctx.getBean("car");
		car.start();
		car.run("vary long");
		
		Bird bird = (Bird) ctx.getBean("bird");
		bird.fly();
		
		Base base = (Base) ctx.getBean("baseImplement");
		base.base();
		Extend baseExtend = (Extend) base;
		baseExtend.extend();
		
		ForExtend forExtend = (ForExtend) ctx.getBean("forExtend");
		forExtend.info();
		Extend extend = (Extend) forExtend;
		extend.extend();
	}
}
