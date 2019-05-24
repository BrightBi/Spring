package bimingliang.annotation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class AutowiredProperties {

	/**
	 * Autowired 注释自动装配的模式是用的byType Autowired 注释有个和 byType 一样的问题就是多个或者零个匹配, 对于零个的使用
	 * Autowired(required=false) 解决； 多个的使用 Qualifier("piano") 解决
	 */

	private Worker worker;

	private Driver driver;

	// 直接在这里注释@Autowired，都可以不用set方法。
	// Autowired 默认是通过 byType 方式装配，此处的 Performer 类型在 xml
	// 配置文件里面有两个（actor，actress）能匹配上
	// 理论上这时候会报错，但实际上并没有。如果把 xml 配置文件中的 id 为 actor 的 bean 改下，id 改成 跟当前属性不同名，
	// 此时就报错。猜测，先 byName 方式装配，如果没有成功再 byType；或者多个类型匹配，会选取属性名跟 id 相同那个，没有相同的就会报错
	@Autowired
	private Performer actor;

	// 直接在这里注释@Autowired，都可以不用set方法。
	// @Qualifier("myActress")表示用 id 为 myActress 的 Bean 来装配(用来解决匹配到多个类型相同的)
	@Autowired
	@Qualifier("myActress")
	private Performer actress;

	// 直接在这里注释 required=false，表示该属性不是必须自动装配，
	// 如果没有找到匹配的类型那么该属性就会为 null。(用来解决没有匹配到类型相同的)
	@Autowired(required = false)
	private Date date;

	// Value 可以用来对一些基本类型进行注入
	@Value("information")
	private String info;

	// 通过 Value 为基本类型赋值，使用SpEL表达式动态赋值
	@Value("#{T(java.lang.Math).PI}")
	private double pie;

	public void show() {
		worker.job();
		driver.job();
		actor.perform();
		actress.perform();
		if (date == null) {
			System.out.println("Date is null.");
		} else {
			System.out.println("Date is " + date);
		}
		System.out.println(info);
		System.out.println(pie);
	}

	public Worker getWorker() {
		return worker;
	}

	// 直接在这里注释@Autowired，会自动调用这个方法装配worker。
	@Autowired
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Driver getDriver() {
		return driver;
	}

	// 直接在这里注释@Autowired，会自动调用这个方法装配driver，
	// 方法名字可以自命名，不一定非要 set 方法才能注释成 Autowired
	@Autowired
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPie() {
		return pie;
	}

	public void setPie(double pie) {
		this.pie = pie;
	}
}
