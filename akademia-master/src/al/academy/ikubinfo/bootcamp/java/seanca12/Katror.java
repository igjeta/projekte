package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Katror {

	private double brinja;

	public Katror(double brinja) {
		this.brinja = brinja;
	}

	public double getBrinja() {
		return brinja;
	}

	public void setBrinja(double brinja) {
		this.brinja = brinja;
	}

	public double siperfaqeKatrori() {
		return brinja * brinja;
	}

	@Override
	public String toString() {
		return "Katror [brinja=" + brinja + ", siperfaqeKatrori()=" + siperfaqeKatrori() + "]";
	}

}
