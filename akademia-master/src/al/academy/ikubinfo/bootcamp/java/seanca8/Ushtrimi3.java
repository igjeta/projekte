package al.academy.ikubinfo.bootcamp.java.seanca8;

import java.util.Scanner;

public class Ushtrimi3 {
	static Scanner input = new Scanner(System.in);

	public static int merrMadhesineEArrayt1D() {
		System.out.println("Vendos madhesine e Arrayt1D: ");
		int madhesia = input.nextInt();

		return madhesia;
	}

	public static void plotesoArrayn1D(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Vendos vleren ne indeksin " + (i + 1) + ": ");
			arr[i] = input.nextInt();
		}
	}

	public static int elementeMeTeMedhenj(int[] arr, int nrKontroll) {
		int numreues = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > nrKontroll) {
				numreues++;
			}
		}
		return numreues;
	}

	public static void main(String[] args) {
		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		System.out.println("Jep nje numer per te pare sa elemente me te medhenj ndodhen ne array");
		int nrKontroll = input.nextInt();

		System.out.println(
				"Numrat qe jane me te medhenj se " + nrKontroll + " jane: " + elementeMeTeMedhenj(arr, nrKontroll));

	}
}
