package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi9 {

	public static double shumaTotale(int[][] arrGlina) {
		int shuma = 0;

		for (int i = 0; i < arrGlina.length; i++) {
			for (int j = 0; j < arrGlina[i].length; j++) {
				shuma += arrGlina[i][j];
			}
		}
		return shuma;
	}

}
