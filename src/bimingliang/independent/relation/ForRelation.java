package bimingliang.independent.relation;

public class ForRelation {
	
	private String color;
	
	private int age;
	
	public void detail() {
		System.out.println("color:" + this.color + "|age:" + this.age);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
