package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Drejtkendesh {

	private double gjatesia;
	private double gjeresia;

	public Drejtkendesh(double gjatesia, double gjeresia) {
		this.gjatesia = gjatesia;
		this.gjeresia = gjeresia;
	}

	public double getGjatesia() {
		return gjatesia;
	}

	public void setGjatesia(double gjatesia) {
		this.gjatesia = gjatesia;
	}

	public double getGjeresia() {
		return gjeresia;
	}

	public void setGjeresia(double gjeresia) {
		this.gjeresia = gjeresia;
	}

	public double siperfaqeDrejtkendeshi() {
		return gjatesia * gjeresia;
	}

	@Override
	public String toString() {
		return "Drejtkendesh [gjatesia=" + gjatesia + ", gjeresia=" + gjeresia + ", siperfaqeDrejtkendeshi()="
				+ siperfaqeDrejtkendeshi() + "]";
	}
	
	
}
