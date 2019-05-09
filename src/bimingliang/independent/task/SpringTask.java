package bimingliang.independent.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

public class SpringTask {

	/*
	 * @Scheduled(fixedRate=10000)
	 * 是从上一个任务开始时开始计算，10秒后开始执行
	 */
	@Scheduled(fixedRate=10000)
	public void taskFixedRate() {
		System.out.println("FixedRate=10000:" + new Date().getTime());
	}
	
	/*
	 * @Scheduled(fixedDelay=2000)
	 * 是从上一个任务结束时开始计算，2秒后开始执行
	 */
	@Scheduled(fixedDelay=2000)
	public void taskFixedDelay() {
		System.out.println("FixedDelay=2000:" + new Date().getTime());
	}
	
	/*
	 * @Scheduled(cron="5,10,15,20 14 17 * * ?")
	 * 使用cron设定时间
	 */
	@Scheduled(cron="5,10,15,20 14 17 * * ?")
	public void taskCron() {
		System.out.println("Cron:" + new Date().getTime());
	}
	
	/*
	 * @Async
	 * 使用异步调用
	 */
	@Async
	public void taskAsync() {
		System.out.println("Async:" + new Date().getTime());
	}
}
