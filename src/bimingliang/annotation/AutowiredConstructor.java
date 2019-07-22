package bimingliang.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredConstructor {
	/**
	 * 如果放在构造函数前，表示这个构造器需要自动装配，即使没有在xml中配置 constructor-arg，
	 * 而且对于构造函数前的 Autowired(required=true) 只能有一个，其余 required 都必须是 false，
	 * Autowired 注释了多个构造器的话，Spring 会从所有满足的当中找那个参数最多的去装配
	 */

	private Worker worker;

	private Driver driver;

	private Performer actor;

	private Performer actress;

	// 此处如果将 构造函数的最后一个入参名字改成与 xml 中配置的 id="myActress" 不一样，比如 actress
	// 此时会认为这个构造函数没有匹配上，从而使用了下面那个具有三个参数的构造函数。
	@Autowired(required=false)
	public AutowiredConstructor(Worker worker, Driver driver, Performer actor, Performer myActress) {
		super();
		this.worker = worker;
		this.driver = driver;
		this.actor = actor;
		this.actress = myActress;
	}

	@Autowired(required=false)
	public AutowiredConstructor(Worker worker, Driver driver, Performer actor) {
		super();
		this.worker = worker;
		this.driver = driver;
		this.actor = actor;
	}

	public AutowiredConstructor(Worker worker, Performer actor) {
		super();
		this.worker = worker;
		this.actor = actor;
	}

	public void show() {
		if (worker != null) {
			worker.job();
		}
		if (driver != null) {
			driver.job();
		}
		if (actor != null) {
			actor.perform();
		}
		if (actress != null) {
			actress.perform();
		}
	}
}
