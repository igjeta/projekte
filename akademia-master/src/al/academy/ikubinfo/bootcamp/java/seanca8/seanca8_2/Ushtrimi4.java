package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi4 {

	public static int gjejNumrinUnik(int[] arr) {
		int numriUnik = 0;
		boolean[] eshteVizituar = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (!eshteVizituar[i]) {
				numriUnik++;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] == arr[j]) {
						eshteVizituar[j] = true;
					}
				}
			}
		}

		return numriUnik;
	}

	public static int gjejIndeksinPerNumrin(int numri, int[][] rezultati) {
		for (int i = 0; i < rezultati.length; i++) {
			if (rezultati[i][0] == numri) {
				return i;
			}
		}
		return -1;
	}

	public static int gjejVendinPerNumrin(int[][] rezultati) {
		for (int i = 0; i < rezultati.length; i++) {
			if (rezultati[i][0] == -1) {
				return i;
			}
		}
		return -1;
	}

	public static int[][] gjejFrekuenca(int[] arr) {
		int numriUnik = gjejNumrinUnik(arr);
		int[][] rezultati = new int[numriUnik][2];

		for (int i = 0; i < numriUnik; i++) {
			rezultati[i][0] = -1;
			rezultati[i][1] = 0;
		}
		for (int numri : arr) {
			int indeksi = gjejIndeksinPerNumrin(numri, rezultati);
			if (indeksi == -1) {
				indeksi = gjejVendinPerNumrin(rezultati);
				rezultati[indeksi][0] = numri;
			}
			rezultati[indeksi][1]++;
		}

		return rezultati;
	}

	public static void printoArray2D(int[][] arr2D) {
		System.out.println("Elementet e arr2D:");

		for (int i = 0; i < arr2D.length; i++) {
			for (int j = 0; j < arr2D[i].length; j++) {
				System.out.print(" " + arr2D[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 7, 3, 5, 2, 2, 2, 2, 3, 3, 3, 22, 2, 22, 22, 22, 11, 11, 11, 11, 11 };

		int[][] rezultati = gjejFrekuenca(arr);

		printoArray2D(rezultati);
	}

}
