package al.academy.ikubinfo.bootcamp.java.seanca4;

public class Metoda {

	final double PI = 3.14;

	public double llogaritPerimeterDrejtkendeshi(double brinjaGjatesise, double brinjaGjeresise) {

		return (2 * brinjaGjatesise) + (2 * brinjaGjeresise);
	}

	public double llogaritSiperfaqeRrethi(double rreze) {

		return rreze * rreze * PI;
	}

	public boolean janeParametratEBarabarte(int parametriPare, int parametriDyte) {
		if (parametriPare == parametriDyte) {
			return true;
		} else
			return false;
	}

	public boolean meIVogelSeDhjete(int numriDhene) {

		if (numriDhene < 10) {
			return true;
		} else
			return false;
	}

	public int ktheDyfishinENumrit(int numer) {

		return 2 * numer;
	}

}
