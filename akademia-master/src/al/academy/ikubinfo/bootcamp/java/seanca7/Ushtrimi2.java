package al.academy.ikubinfo.bootcamp.java.seanca7;

import java.util.Scanner;

public class Ushtrimi2 {
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

	public static int gjejPozicionElementiNeArray1D(int[] arr, int element) {
		for (int pozicion = 0; pozicion < arr.length; pozicion++) {
			if (arr[pozicion] == element) {
				return pozicion;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		System.out.println("Vendos elementin qe do te kontrollosh nese ndodhet ne array: ");
		int elementKontroll = input.nextInt();

		if (gjejPozicionElementiNeArray1D(arr, elementKontroll) == -1) {
			System.out.println("Elementi nuk u gjet!");
		} else {
			System.out.println("Elementi i dhene " + elementKontroll + " gjendet ne pozicionin "
					+ (gjejPozicionElementiNeArray1D(arr, elementKontroll) + 1));
		}
	}
}
