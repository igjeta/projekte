package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Pedagog extends Person {

	private int nrLendesh;
	private double paga;

	public Pedagog(int nrLendesh, double paga, String emer, String adrese) {
		super(emer, adrese);
		this.nrLendesh = nrLendesh;
		this.paga = paga;
	}

	public Pedagog() {

	}

	public int getNrLendesh() {
		return nrLendesh;
	}

	public void setNrLendesh(int nrLendesh) {
		this.nrLendesh = nrLendesh;
	}

	public double getPaga() {
		return paga;
	}

	public void setPaga(double paga) {
		this.paga = paga;
	}

	@Override
	public String toString() {
		return "Pedagog [nrLendesh=" + nrLendesh + ", paga=" + paga + ", toString()=" + super.toString() + "]";
	}

}