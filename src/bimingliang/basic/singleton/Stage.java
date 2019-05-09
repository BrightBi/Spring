package bimingliang.basic.singleton;

public class Stage {

	private Stage() {
	}

	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}

	public static Stage getInstance() {
		return StageSingletonHolder.instance;
	}
	
	public void doSomething () {
		System.out.println("Stage doSomething");
	}
}
