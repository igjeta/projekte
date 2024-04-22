package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class NumberReverse {

	public static int reverseNumber(int numer) {
		int reverse = 0;
		while (numer != 0) {
			int mbetje = numer % 10;
			reverse = reverse * 10 + mbetje;
			numer /= 10;
		}
		return reverse;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Shkruani nje numer!");

		int numer = input.nextInt();

		System.out.println("Numri ne reverse eshte "+reverseNumber(numer));

	}

}
