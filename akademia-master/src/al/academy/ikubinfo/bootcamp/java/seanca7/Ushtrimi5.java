package al.academy.ikubinfo.bootcamp.java.seanca7;

import java.util.Scanner;

public class Ushtrimi5 {
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

	public static void elementetEDublikuar(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(arr[i]);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int madhesia = merrMadhesineEArrayt1D();
		int[] arr = new int[madhesia];

		plotesoArrayn1D(arr);

		System.out.println("Elementet e dublikuar jane: ");
		elementetEDublikuar(arr);
	}

}
