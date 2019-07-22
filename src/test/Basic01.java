package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bimingliang.basic.Auditorium;
import bimingliang.basic.Instrumentalist;
import bimingliang.basic.Juggler;
import bimingliang.basic.OneManBand;
import bimingliang.basic.PoeticJuggler;
import bimingliang.basic.Sonnet;
import bimingliang.basic.SpEL;
import bimingliang.basic.Student;
import bimingliang.basic.editor.Property;
import bimingliang.basic.singleton.Stage;

public class Basic01 {

	public static void main(String[] args) {

		/*
		 *  ClassPathXmlApplicationContext 是读取 src 目录下的配置文件 
		 *  ApplicationContext ac = new ClassPathXmlApplicationContext("Basic.xml "); 
		 *  FileSystemXmlApplicationContext 即系统文件路径，文件的目录(Eclipse中的项目根路径)。 
		 *  ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\MyWorkspace\\Spring\\src\\Basic.xml");
		 *  AnnotationConfigApplicationContext 从 Java 类中，根据 Bean 注解来加载
		 *  ApplicationContext ac = new AnnotationConfigApplicationContext(bimingliang.annotation.java.CreateBeans);
		 */
		// ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\MyWorkspace\\Spring\\src\\Basic.xml");
		ApplicationContext acAnnotation = new AnnotationConfigApplicationContext(bimingliang.annotation.java.CreateBeans.class);
		String[] beansNameAnnotation = acAnnotation.getBeanDefinitionNames();
		for (String name : beansNameAnnotation) {
			System.out.println(name);
		}
		System.out.println("**************************************************");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Basic.xml");
		String[] beansName = ac.getBeanDefinitionNames();
		for (String name : beansName) {
			System.out.println(name);
		}
		System.out.println("**************************************************");

		Juggler duke = (Juggler) ac.getBean("duke");
		duke.perform();

		PoeticJuggler poeticJuggler = (PoeticJuggler) ac.getBean("poeticJuggler");
		poeticJuggler.perform();

		Student student = (Student) ac.getBean("student");
		student.sayDetail();

		Stage stage = (Stage) ac.getBean("stage");
		stage.doSomething();
		Student singletonStudent1 = (Student) ac.getBean("singletonStudent");
		singletonStudent1.sayDetail();
		Student singletonStudent2 = (Student) ac.getBean("singletonStudent");
		singletonStudent2.sayDetail();
		System.out.println("singletonStudent1:" + singletonStudent1.hashCode() + " | singletonStudent2:" + singletonStudent2.hashCode());

		Auditorium auditorium = (Auditorium) ac.getBean("auditorium");
		auditorium.doSomething();

		Sonnet sonnet1 = (Sonnet) ac.getBean("sonnet");
		Sonnet sonnet2 = (Sonnet) ac.getBean("sonnet");
		Juggler duke1 = (Juggler) ac.getBean("duke");
		Juggler duke2 = (Juggler) ac.getBean("duke");
		System.out.println("sonnet1:" + sonnet1.hashCode() + " | sonnet2:" + sonnet2.hashCode());
		System.out.println("duke1:" + duke1.hashCode() + " | duke2:" + duke2.hashCode());

		Instrumentalist instrumentalist = (Instrumentalist) ac.getBean("instrumentalist");
		instrumentalist.perform();
		Instrumentalist instrumentalistP = (Instrumentalist) ac.getBean("instrumentalistP");
		instrumentalistP.perform();
		OneManBand oneManBand = (OneManBand) ac.getBean("oneManBand");
		oneManBand.perform();
		System.out.println("OneManBand.date:" + oneManBand.getDate());
		
		SpEL spEL = (SpEL) ac.getBean("spEL");
		System.out.println(spEL.toString());
		
		Property property = (Property) ac.getBean("property");
		property.detail();

	}

}
