package bimingliang.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutowiredQualifier {

	/**
	 * 由于注解注入是 byType 的，如果 xml 中有多个 bean 类型能匹配上，
	 * 就需要进行限定，确保有一个确定的bean 用于装配。
	 * 一下是三种可行方式
	 * 1 @Qualifier("selfMarkStudent") 其中 selfMarkStudent 可以限定在类上，
	 *   此处是限定在 Student 类上
	 * 2 @Qualifier("selfMarkTeacher") 其中 selfMarkTeacher 是配置在 Spring 的 bean 中，
	 *   此处 <bean id="teacher" class="bimingliang.annotation.Teacher">
	 *           <qualifier value="selfMarkTeacher" />
	 *        </bean>
	 * 3 @Qualifier("schoolmaster") 其中 schoolmaster 直接指定 bean 的 id
	 */
	@Autowired
	@Qualifier("selfMarkStudent")
	private Person person1;
	@Autowired
	@Qualifier("selfMarkTeacher")
	private Person person2;
	@Autowired
	@Qualifier("schoolmaster")
	private Person person3;

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public Person getPerson3() {
		return person3;
	}

	public void setPerson3(Person person3) {
		this.person3 = person3;
	}

	public void show() {
		if (person1 != null) {
			person1.talk();
		}
		if (person2 != null) {
			person2.talk();
		}
		if (person3 != null) {
			person3.talk();
		}
	}
}
