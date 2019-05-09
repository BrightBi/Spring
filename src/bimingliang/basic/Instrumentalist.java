package bimingliang.basic;

public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;
	private Instrument instrumentInner;

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	public void setInstrumentInner(Instrument instrumentInner) {
		this.instrumentInner = instrumentInner;
	}

	public String screamSong() {
		return song;
	}

	@Override
	public void perform() {
		System.out.print("Playing " + song + " : ");
		instrument.paly();
		instrumentInner.paly();
		System.out.println();
	}
}
