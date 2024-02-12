package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi5 {

	public static int[][] konvertoArr2D(int[][] arr2D) {
		int rreshta = arr2D.length;
		int kolonat = arr2D[0].length;

		int[][] arr2DKonvertuar = new int[kolonat][rreshta];

		for (int i = 0; i < rreshta; i++) {
			for (int j = 0; j < kolonat; j++) {
				arr2DKonvertuar[j][i] = arr2D[i][j];
			}
		}

		return arr2DKonvertuar;
	}
}