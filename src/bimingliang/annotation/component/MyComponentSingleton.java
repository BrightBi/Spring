package bimingliang.annotation.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

// @Component(value="selfName")指定默认名字selfName，否则默认名字为首字母小写的类名
@Component(value="selfComponentName")
public class MyComponentSingleton {

	// @PostConstruct 指定多个初始化方法类似标签中init-method
	@PostConstruct
	public void initFirst() {
		System.out.println("MyComponentSingleton init first.");
	}

	@PostConstruct
	public void initSecond() {
		System.out.println("MyComponentSingleton init second.");
	}

	// @PreDestroy 指定多个销毁方法类似标签中destory-method
	@PreDestroy
	public void destroyFirst() {
		System.out.println("MyComponentSingleton destroy first.");
	}

	@PreDestroy
	public void destroySecond() {
		System.out.println("MyComponentSingleton destroy second.");
	}
}
