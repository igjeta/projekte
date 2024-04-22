package al.academy.ikubinfo.bootcamp.java.seanca12;

public class MainUshtrimi2 {

	public static void main(String[] args) {

		Rreth rreth = new Rreth(1.7, "jeshile");
		Cilinder cilinder = new Cilinder(1.4, "verdhe", 2.4);

		System.out.println("Siperfaqja rrethit eshte " + rreth.siperfaqjaRrethit());
		System.out.println("Vellimi cilindrit eshte " + cilinder.vellimiCilindrit());
	}
}
