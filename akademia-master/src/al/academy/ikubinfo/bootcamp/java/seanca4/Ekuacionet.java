package al.academy.ikubinfo.bootcamp.java.seanca4;

public class Ekuacionet {

	public double llogaritVlerenEkuacionitFuqisePareMeNjeNdryshore(double a, double b, double c) {

		return (c - b) / a;
	}

	public void llogaritVlerenEkuacionitFuqiseDyteMeNjeNdryshore(double a, double b, double c) {
		double dallor = (b * b) - 4 * a * c;

		if (dallor > 0) {
			double x1 = (-b + Math.sqrt(dallor)) / (2 * a);
			double x2 = (-b - Math.sqrt(dallor)) / (2 * a);

			System.out.println("Dallori eshte me i madh se zero dhe zgjidhjet e ekuacionit jane x1=" + x1 + ", dhe x2="
					+ x2 + ".");

		} else if (dallor == 0) {
			double x = -b / (2 * a);

			System.out.println("Dallori eshte i barabarte me 0 dhe ka vetem nje zgjidhje qe eshte x=" + x + ".");
		} else {
			System.out.println(
					"Dallori eshte me i vogel se zero dhe ekuacioni nuk ka zgjidhje ne bashkesine e numrave reale.");
		}
	}

}
