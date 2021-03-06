package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.annotation.AutowiredConstructor;
import bimingliang.annotation.AutowiredProperties;
import bimingliang.annotation.AutowiredQualifier;
import bimingliang.annotation.InjectProperties;
import bimingliang.annotation.component.MyComponentPrototype;
import bimingliang.annotation.component.MyComponentSingleton;
import bimingliang.annotation.java.Air;
import bimingliang.annotation.java.Water;
import bimingliang.annotation.scan.Color;
import bimingliang.annotation.scan.detail.SpecialColor;

public class Annotation03 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Annotation.xml");

		String[] beansName = ctx.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("*************************AutowiredProperties*************************");

		AutowiredProperties autowiredProperties = (AutowiredProperties) ctx.getBean("autowiredProperties");
		autowiredProperties.show();

		System.out.println("*************************AutowiredConstructor*************************");
		AutowiredConstructor autowiredConstructor = (AutowiredConstructor) ctx.getBean("autowiredConstructor");
		autowiredConstructor.show();

		System.out.println("*************************AutowiredQualifier*************************");
		AutowiredQualifier autowiredQualifier = (AutowiredQualifier) ctx.getBean("autowiredQualifier");
		autowiredQualifier.show();

		System.out.println("*************************InjectProperties*************************");
		InjectProperties injectProperties = (InjectProperties) ctx.getBean("injectProperties");
		injectProperties.show();

		System.out.println("*************************ScanBean*************************");
		Color red = (Color) ctx.getBean("red");
		red.show();
		Color purple = (Color) ctx.getBean("purple");
		purple.show();
		SpecialColor specialColor = (SpecialColor) ctx.getBean("specialColor");
		specialColor.show();
		System.out.println("*************************JavaCreateBean*************************");

		Air air = (Air) ctx.getBean("air");
		air.show();
		Water water = (Water) ctx.getBean("selfName");
		water.show();
		System.out.println("************************* Component *************************");
		MyComponentPrototype myComponentPrototype1 = (MyComponentPrototype) ctx.getBean("myComponentPrototype");
		MyComponentPrototype myComponentPrototype2 = (MyComponentPrototype) ctx.getBean("myComponentPrototype");
		System.out.println("myComponentPrototype1 :" + myComponentPrototype1.hashCode());
		System.out.println("myComponentPrototype2 :" + myComponentPrototype2.hashCode());
		
		System.out.println("************************* Component *************************");
		MyComponentSingleton selfComponentName1 = (MyComponentSingleton) ctx.getBean("selfComponentName");
		MyComponentSingleton selfComponentName2 = (MyComponentSingleton) ctx.getBean("selfComponentName");
		System.out.println("selfComponentName1 :" + selfComponentName1.hashCode());
		System.out.println("selfComponentName2 :" + selfComponentName2.hashCode());

		((ClassPathXmlApplicationContext)ctx).destroy();
	}

}
