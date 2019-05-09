package bimingliang.basic;

public class Guitar implements Instrument {
	@Override
	public void paly() {
		System.out.println("Guitar:" + this.hashCode());
	}
}
