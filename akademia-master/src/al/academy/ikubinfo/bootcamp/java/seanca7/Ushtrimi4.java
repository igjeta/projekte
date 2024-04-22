package al.academy.ikubinfo.bootcamp.java.seanca7;

import java.util.Scanner;

public class Ushtrimi4 {

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

	public static void printoArray1D(int[] arr) {
		System.out.println("Elementet e arrayt1D:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Vlera ne indeksin " + (i + 1) + ": " + arr[i]);
		}
	}

	public static int[] hiqElementinEPare(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		return arr;
	}

	public static void main(String[] args) {
		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		System.out.println("Array i dhene: ");
		printoArray1D(arr);

		System.out.println("Array pasi hoqem elementin e pare: ");
		printoArray1D(hiqElementinEPare(arr));
	}

}
