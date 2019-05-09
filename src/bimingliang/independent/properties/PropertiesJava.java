package bimingliang.independent.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class PropertiesJava {

	// @Value("${time}")从配置文件中取配置数据
	@Value("${time}")
	private String time;
	
	@Value("${size}")
	private String size;
	
	@Value("${passwordEncode}")
	private String passwordEncode;
	
	public void detail() {
		System.out.println("PropertiesJava:time=" + this.time + "| size=" + this.size + "| passwordEncode=" + this.passwordEncode);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPasswordEncode() {
		return passwordEncode;
	}

	public void setPasswordEncode(String passwordEncode) {
		this.passwordEncode = passwordEncode;
	}
}
