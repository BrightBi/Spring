package bimingliang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BiMingjie {

	// 切点，需要附在一个方法上。方法只提供一个依附，一般为空方法
	@Pointcut("execution(* bimingliang.aop.Car.start(..))")
	public void biMingjie(){}
	
	@Pointcut("execution(* bimingliang.aop.Car.run(String)) && args(length)")
	public void biMingjieParameter(String length){}
	
	@Before("biMingjie()")
	public void before() {
		System.out.println("BiMingjie Before ...");
	}
	
	@AfterReturning(value="biMingjie()", returning="ret")
	public void after(String ret) {
		System.out.println("BiMingjie AfterReturning . Return " + ret);
	}
	
	@AfterThrowing("biMingjie()")
	public void throwing() {
		System.out.println("BiMingjie AfterThrowing ...");
	}
	
	@Around("biMingjie()")
	public void watch(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			System.out.println("Bimingjie watch begin ... ");
			proceedingJoinPoint.proceed();
			System.out.println("Bimingjie watch end ... ");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Before("biMingjieParameter(length)")
	public void watchLength(String length) {
		System.out.println("BiMingjie run " + length + ".");
	}
}
