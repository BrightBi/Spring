package bimingliang.basic;

public class Student implements People {
	
	private String name = "Default";
	
	private int age = 0;
	
	private People friend;
	
	public Student() {}
	
	public Student(String name, int age, People friend) {
		this.name = name;
		this.age = age;
		this.friend = friend;
	}
	
	@Override
	public void sayDetail() {
		System.out.println("I am " + this.getName() + ".");
		System.out.println("I'm " + this.getAge() + ".");
		if (this.getFriend() == null) {
			System.out.println("I don't have friend.");
		} else {
			System.out.println("My friend is " + this.getFriend().hashCode() + ".");
		}
		System.out.println("Hash Code:" + this.hashCode());
	}
	
	@Override
	public void resetInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public People getFriend() {
		return friend;
	}

	public void setFriend(People friend) {
		this.friend = friend;
	}

}
