package al.academy.ikubinfo.bootcamp.java.seanca7;

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

	public static int gjejPozicionElementiNeArray1D(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public static int[] hiqElement(int[] arr, int pozicion) {
		int[] arrayRi = new int[arr.length - 1];
		int indeks = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i != pozicion) {
				arrayRi[indeks] = arr[i];
				indeks++;
			}
		}

		return arrayRi;
	}

	public static void printoArray1D(int[] arr) {
		System.out.println("Elementet e arrayt1D:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Vlera ne indeksin " + (i + 1) + ": " + arr[i]);
		}
	}

	public static void main(String[] args) {

		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		System.out.println("Vendos elementin qe do te heqesh ne array: ");
		int hiqElement = input.nextInt();

		System.out.println("Array i pare:");
		printoArray1D(arr);

		if (gjejPozicionElementiNeArray1D(arr, hiqElement) != -1) {
			hiqElement(arr, gjejPozicionElementiNeArray1D(arr, hiqElement));

			System.out.println("Array i dyte pasi u hoq elementi: " + hiqElement);
			printoArray1D(hiqElement(arr, gjejPozicionElementiNeArray1D(arr, hiqElement)));
		} else {
			System.out.println("Elementi i dhene " + hiqElement + " nuk ndodhet ne arrayn e dhene!");
		}

	}

}
