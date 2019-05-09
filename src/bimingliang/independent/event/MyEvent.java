package bimingliang.independent.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MyEvent extends ApplicationContextEvent{

	private static final long serialVersionUID = 1L;
	
	private String info;
	
	public MyEvent(ApplicationContext applicationContext, String info) {
		super(applicationContext);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
