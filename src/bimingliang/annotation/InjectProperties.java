package bimingliang.annotation;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

public class InjectProperties {
	/**
	 * Inject 注释用法跟 Autowired 一样，几乎可以完全替代 Autowired， 不同于 Autowired，Inject 没有
	 * required 属性，所以 Inject 注释的属性必须在 Spring 的配置文件里有配置.
	 * Autowired 配合 Qualifier 来限定 bean，同样 Inject 配合 Named 来限定 bean。
	 */

	private Worker worker;

	private Driver driver;

	@Inject
	private Performer actor;

	@Inject
	@Named("myActress")
	private Performer actress;

	// 此处只能使用 Autowired，不能用 Inject，因为 Date 类型在配置文件中没有配置
	@Autowired(required = false)
	private Date date;

	public void show() {
		this.worker.job();
		this.driver.job();
		this.actor.perform();
		this.actress.perform();
		if (this.date == null) {
			System.out.println("Date is null.");
		} else {
			System.out.println("Date is " + this.date);
		}
	}

	public Worker getWorker() {
		return worker;
	}

	@Inject
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Driver getDriver() {
		return driver;
	}

	@Inject
	public void setMyDriver(Driver driver) {
		this.driver = driver;
	}

	public Performer getActress() {
		return actress;
	}

	public void setActress(Performer actress) {
		this.actress = actress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
