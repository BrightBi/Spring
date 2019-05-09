package bimingliang.db;

import java.sql.Date;
import java.util.UUID;

public class DB {

	private int id;

	private UUID guid;

	private String name;

	private int age;

	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UUID getGuid() {
		return guid;
	}

	public void setGuid(UUID guid) {
		this.guid = guid;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "DB [id=" + id + ", guid=" + guid + ", name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

}
