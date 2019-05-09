package bimingliang.annotation.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在 xml 中配置了自动扫描 bimingliang.java 包中的类来装配
 * Configuration 会告知 Spring 这个类可能返回多个配置 Bean
 */
@Configuration
public class CreateBeans {
	
	// @Bean 告知 Spring 当前方法返回的对象将被装配起来，Bean 的 id 就是方法名字
	@Bean
	public Air air() {
		return new Air();
	}
	
	// Bean 的 id 被指定为 selfName
	@Bean(name="selfName")
	public Water water() {
		return new Water();
	}
}
