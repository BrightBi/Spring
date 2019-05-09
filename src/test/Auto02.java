package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.auto.CreateByConstructor;
import bimingliang.auto.CreateByName;
import bimingliang.auto.CreateByType;

public class Auto02 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Auto.xml");

		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("*************************CreateByName*************************");

		CreateByName createByName = (CreateByName) ctx.getBean("createByName");
		createByName.getAnimal().shut();
		if (createByName.getGoodAnimal() == null) {
			System.out.println("No good animal.");
		} else {
			createByName.getGoodAnimal().shut();
		}
		System.out.println("*************************CreateByType*************************");
		
		CreateByType createByType = (CreateByType) ctx.getBean("createByType");
		createByType.getAnimal().shut();
		if (createByType.getCat() == null) {
			System.out.println("No cat.");
		} else {
			createByType.getCat().shut();
		}
		System.out.println("*************************CreateByConstructor*************************");
		
		CreateByConstructor createByConstructor = (CreateByConstructor) ctx.getBean("createByConstructor");
		createByConstructor.getAnimal().shut();
		createByConstructor.getCat().shut();
	}
}
