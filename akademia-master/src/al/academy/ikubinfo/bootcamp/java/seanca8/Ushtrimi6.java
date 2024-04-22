package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi6 {

	public static void printoShumenKolonave(int[][] arr2D) {
		int rreshta = arr2D.length;
		int kolonat = arr2D[0].length;

		for (int i = 0; i < kolonat; i++) {
			int shumaKolones = 0;

			for (int j = 0; j < rreshta; j++) {
				shumaKolones += arr2D[i][j];
			}

			System.out.println("Shuma e kolonës " + (i + 1) + ": " + shumaKolones);
		}
	}
	
	public static void main(String[] args) {
		int[][] matrica = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
		printoShumenKolonave(matrica);
		
	}
}