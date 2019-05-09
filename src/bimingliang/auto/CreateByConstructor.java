package bimingliang.auto;

public class CreateByConstructor {
	
	private Animal animal;
	
	private Cat cat;
	
	public CreateByConstructor(Animal animal, Cat cat) {
		this.animal = animal;
		this.cat = cat;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
}
