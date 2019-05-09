package bimingliang.independent.properties;

import org.springframework.beans.factory.annotation.Autowired;

public class Properties {

	private String time;
	
	private String size;
	
	private String password;
	
	@Autowired
	private PropertiesJava propertiesJava;
	
	public void detail() {
		System.out.println("Properties:time=" + this.time + "| size=" + this.size + "| password=" + this.password);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PropertiesJava getPropertiesJava() {
		return propertiesJava;
	}

	public void setPropertiesJava(PropertiesJava propertiesJava) {
		this.propertiesJava = propertiesJava;
	}
}
