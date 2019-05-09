package bimingliang.basic;

public class Saxophone implements Instrument {

	@Override
	public void paly() {
		System.out.println("Saxophone:" + this.hashCode());
	}

}
