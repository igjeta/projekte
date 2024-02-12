package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class LexoPrinto {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int shumaDyShifrarorve = 0;

		System.out.println("Shkruani nje numer: ");

		while (input.hasNextInt()) {
			System.out.println("Shkruani nje numer: ");
			int numer = input.nextInt();
			System.out.println("Numri qe ju vendoset eshte : " + numer);
			if (numer > 9 && numer < 100) {
				shumaDyShifrarorve += numer;
			}
		}
		System.out.println("Shuma e numrave dyshriror te dhene eshte " + shumaDyShifrarorve);
	}

}
