package bimingliang.basic.singleton;

import bimingliang.basic.Student;

public class Singleton {
	
	private Singleton() {
    }
    
    public Student getStudent() {
    	return new Student("BiMingliang", 17, null);
    }
}
