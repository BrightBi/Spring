package bimingliang.basic.editor;

public class Property {

	private MyType myType;
	
	public void detail() {
		System.out.println("MyType:" + this.myType.getFirstProperty() + "|" + this.myType.getSecondProperty());
	}

	public MyType getMyType() {
		return myType;
	}

	public void setMyType(MyType myType) {
		this.myType = myType;
	}
}
