package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi5 {

	public static void gjejElementetMaxRrjesht(int[][] array2D) {
		System.out.println("Elementet max te cdo rreshti:");

		for (int i = 0; i < array2D.length; i++) {
			int maxRrjeshti = array2D[i][0];

			for (int j = 1; j < array2D[i].length; j++) {
				if (array2D[i][j] > maxRrjeshti) {
					maxRrjeshti = array2D[i][j];
				}
			}

			System.out.println("Rreshti " + (i + 1) + ": " + maxRrjeshti);
		}
	}

	public static void gjejElementetMaxKolone(int[][] array2D) {
		System.out.println("\nElementet max te cdo kolone:");

		for (int j = 0; j < array2D[0].length; j++) {
			int maxKolone = array2D[0][j];

			for (int i = 1; i < array2D.length; i++) {
				if (array2D[i][j] > maxKolone) {
					maxKolone = array2D[i][j];
				}
			}

			System.out.println("Kolona " + (j + 1) + ": " + maxKolone);
		}
	}

}
