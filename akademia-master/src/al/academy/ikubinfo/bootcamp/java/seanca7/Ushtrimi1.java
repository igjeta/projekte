package al.academy.ikubinfo.bootcamp.java.seanca7;

import java.util.Scanner;

public class Ushtrimi1 {

	static Scanner input = new Scanner(System.in);

	public static int merrMadhesineEArrayt1D() {
		System.out.println("Vendos madhesine e Arrayt1D: ");
		int madhesia = input.nextInt();

		return madhesia;
	}

	public static void plotesoArrayn1D(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Vendos vleren ne indeksin " + (i+1) + ": ");
			arr[i] = input.nextInt();
		}
	}

	public static double llogaritMesatareArray1D(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}

		int shuma = 0;
		for (int vlera : arr) {
			shuma += vlera;
		}

		return (double) shuma / arr.length;
	}

	public static void main(String[] args) {

		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		double mesatare = llogaritMesatareArray1D(arr);
		System.out.println("Mesatarja e arrayt te dhene eshte: " + mesatare);

	}
}
