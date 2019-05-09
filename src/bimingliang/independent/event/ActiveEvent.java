package bimingliang.independent.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ActiveEvent implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void activeEvent() {
		MyEvent myEvent = new MyEvent(applicationContext, "Active an event.");
		applicationContext.publishEvent(myEvent);
	}
}
