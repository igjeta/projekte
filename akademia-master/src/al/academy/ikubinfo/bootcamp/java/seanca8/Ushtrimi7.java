package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi7 {

	public static boolean kontrolloDiagonalet(int[][] arr2D) {
		int shumaDiagonaleKryesore = 0;
		int shumaDiagonaleDytesore = 0;
		int gjatsia = arr2D.length;

		for (int i = 0; i < gjatsia; i++) {
			shumaDiagonaleKryesore += arr2D[i][i];
			shumaDiagonaleDytesore += arr2D[i][gjatsia - 1 - i];
		}

		if (shumaDiagonaleKryesore == shumaDiagonaleDytesore) {
			return true;

		} else
			return false;
	}
}
