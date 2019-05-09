package bimingliang.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class BiMingliang {
	
	public void up() {
		System.out.println("Morning ... ");
	}
	
	public void eate() {
		System.out.println("Good food ... ");
	}
	
	public void work() {
		System.out.println("Working hard ... ");
	}
	
	public void play() {
		System.out.println("Very happy ... ");
	}
	
	public void sleep() {
		System.out.println("Evening ... ");
	}
	
	// 环绕通知
	public void watch(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			System.out.println("Watch begin ... ");
			proceedingJoinPoint.proceed();
			System.out.println("Watch end ... ");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	// 带有参数
	public void watchLength(String length) {
		System.out.println("It run " + length + ".");
		length = "run run run...";
	}
}