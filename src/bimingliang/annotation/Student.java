package bimingliang.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("selfMarkStudent")
public class Student implements Person {

	@Override
	public void talk() {
		System.out.println("Student talk ...");
	}
}
