package al.academy.ikubinfo.bootcamp.java.seanca4;

import java.util.Scanner;

public class Mosha {

	public static int llogaritMoshen(int vitiLindjes) {

		return 2023 - vitiLindjes; //jo gjithmone eshte e sakte se nuk llogaritet data fikse
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Ju lutem vendosni vitin e lindjes");

		int vitiLindjes = input.nextInt();

		int mosha = llogaritMoshen(vitiLindjes);

		if (mosha <= 20) {
			System.out.println("Kategoria deri në 20!");
		} else if (mosha <= 50 && mosha > 20) {
			System.out.println("Kategoria mbi 20 deri në 50!");
		} else {
			System.out.println("Kategoria mbi 50!");
		}

	}

}
