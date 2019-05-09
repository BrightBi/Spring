package bimingliang.annotation.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Scope("prototype") 指定每次返回一个新对象。不使用单例
@Scope("prototype")
@Component()
public class MyComponentPrototype {

	// @PostConstruct 指定多个初始化方法类似标签中init-method
	@PostConstruct
	public void initFirst() {
		System.out.println("MyComponentPrototype init first.");
	}

	@PostConstruct
	public void initSecond() {
		System.out.println("MyComponentPrototype init second.");
	}

	// @PreDestroy 指定多个销毁方法类似标签中destory-method
	@PreDestroy
	public void destroyFirst() {
		System.out.println("MyComponentPrototype destroy first.");
	}

	@PreDestroy
	public void destroySecond() {
		System.out.println("MyComponentPrototype destroy second.");
	}
}
