package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Trekendesh {

	private double baza;
	private double lartesia;
	private double brinja2;
	private double brinja3;
	private int lloji;

	public Trekendesh(double baza, double lartesia, double brinja2, double brinja3, int lloji) {
		super();
		this.baza = baza;
		this.lartesia = lartesia;
		this.brinja2 = brinja2;
		this.brinja3 = brinja3;
		this.lloji = lloji;
	}

	public double getBaza() {
		return baza;
	}

	public void setBaza(double baza) {
		this.baza = baza;
	}

	public double getLartesia() {
		return lartesia;
	}

	public void setLartesia(double lartesia) {
		this.lartesia = lartesia;
	}

	public double getBrinja2() {
		return brinja2;
	}

	public void setBrinja2(double brinja2) {
		this.brinja2 = brinja2;
	}

	public double getBrinja3() {
		return brinja3;
	}

	public void setBrinja3(double brinja3) {
		this.brinja3 = brinja3;
	}

	public String getLloji() {
		switch (lloji) {
		case 0:
			return "DyBrinjeNjeshem";
		case 1:
			return "KendDrejte";
		case 2:
			return "KendDrejte dhe DybrinjeNjeshem";
		default:
			return "I Crregullt";
		}
	}

	public void setLloji(int lloji) {
		this.lloji = lloji;
	}

	public double siperfaqeTrekendeshi() {
		return (baza * lartesia) / 2;
	}

	@Override
	public String toString() {
		return "Trekendesh [baza=" + baza + ", lartesia=" + lartesia + ", brinja2=" + brinja2 + ", brinja3=" + brinja3
				+ ", getLloji()=" + getLloji() + ", siperfaqeTrekendeshi()=" + siperfaqeTrekendeshi() + "]";
	}

}
