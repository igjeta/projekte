package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Rreth {

	private double rreze;
	private String ngjyre;

	public Rreth() {
		this.rreze = 1.0;
		this.ngjyre = "blu";
	}

	public Rreth(double rreze, String ngjyre) {
		this.rreze = rreze;
		this.ngjyre = ngjyre;
	}

	public Rreth(double rreze) {
		this.rreze = rreze;
	}

	public void setRreze(double rreze) {
		this.rreze = rreze;
	}

	public double getRreze() {
		return rreze;
	}

	public String getNgjyre() {
		return ngjyre;
	}

	public void setNgjyre(String ngjyre) {
		this.ngjyre = ngjyre;
	}

	public double siperfaqjaRrethit() {
		return 3.14 * rreze * rreze;
	}

	public double perimetriRrethit() {
		return 2 * 3.14 * rreze;
	}

	@Override
	public String toString() {
		return "Rreth [rreze=" + rreze + ", ngjyre=" + ngjyre + ", siperfaqjaRrethit()=" + siperfaqjaRrethit()
				+ ", perimetriRrethit()=" + perimetriRrethit() + "]";
	}
}
