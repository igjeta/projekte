package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Student extends Person {

	private int nrLendesh;
	private double mesatarja;

	public Student(int nrLendesh, double mesatarja, String emer, String adrese) {
		super(emer, adrese);
		this.nrLendesh = nrLendesh;
		this.mesatarja = mesatarja;
	}

	public Student() {

	}

	public int getNrLendesh() {
		return nrLendesh;
	}

	public void setNrLendesh(int nrLendesh) {
		this.nrLendesh = nrLendesh;
	}

	public double getMesatarja() {
		return mesatarja;
	}

	public void setMesatarja(double mesatarja) {
		this.mesatarja = mesatarja;
	}

	@Override
	public String toString() {
		return "Student [nrLendesh=" + nrLendesh + ", mesatarja=" + mesatarja + ", toString()=" + super.toString()
				+ "]";
	}

}