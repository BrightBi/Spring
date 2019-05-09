package bimingliang.basic;

public class SpEL {
	private int number;
	private double weight;
	private boolean enable;
	private String detail;
	private Sonnet sonnet;
	private String sonnetId;
	private double random;
	private double pi;
	private double basicOperation;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Sonnet getSonnet() {
		return sonnet;
	}

	public void setSonnet(Sonnet sonnet) {
		this.sonnet = sonnet;
	}

	public String getSonnetId() {
		return sonnetId;
	}

	public void setSonnetId(String sonnetId) {
		this.sonnetId = sonnetId;
	}

	public double getRandom() {
		return random;
	}

	public void setRandom(double random) {
		this.random = random;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

	public double getBasicOperation() {
		return basicOperation;
	}

	public void setBasicOperation(double basicOperation) {
		this.basicOperation = basicOperation;
	}

	@Override
	public String toString() {
		return "SpEL [number=" + number + ", weight=" + weight + ", enable=" + enable + ", detail=" + detail
				+ ", sonnet=" + sonnet + ", sonnetId=" + sonnetId + ", random=" + random + ", pi=" + pi
				+ ", basicOperation=" + basicOperation + "]";
	}

}
