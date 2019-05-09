package bimingliang.independent.event;

import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<MyEvent>{

	@Override
	public void onApplicationEvent(MyEvent myEvent) {
		System.out.println("Do something. " + myEvent.getInfo()); 
	}
}
