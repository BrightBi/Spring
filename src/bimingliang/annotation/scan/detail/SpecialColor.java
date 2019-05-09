package bimingliang.annotation.scan.detail;

import org.springframework.stereotype.Component;


/**
 * 在 Scan.xml 中配置了自动扫描 bimingliang.scan 包中的类来装配。当发现标有注解 Component，就会自动装配
 * 使用 Component("specialColor")，Spring 会自动将 SpecialColor 注册为一个Bean，其 ID 为 specialColor，
 * 如果不指定 ID 默认将会是类名 specialColor(注意是 specialColor，不是 SpecialColor)
 */
@Component("specialColor")
public class SpecialColor {

	public void show() {
		System.out.println("This color is special.");
	}
	
}