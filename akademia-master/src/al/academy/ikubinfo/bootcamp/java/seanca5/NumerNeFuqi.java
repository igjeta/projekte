package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class NumerNeFuqi {

	public static int llogaritFuqine(int numri, int eksponenti) {
		int rezultati = numri;
		for (int i = 1; i < eksponenti; i++) {
			rezultati = rezultati * numri;
		}
		return rezultati;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Shkruani nje numer.");
		int numer = input.nextInt();

		System.out.println("Shkruani eksponentin per numrin e dhene.");
		int eksponenti = input.nextInt();

		System.out.println("Rezultati per numrin " + numer + " me eksponentin e tij " + eksponenti + " te dhene eshte "
				+ llogaritFuqine(numer, eksponenti) + " .");

	}

}
