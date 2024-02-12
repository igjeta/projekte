package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi8 {
	public static void printoNotat(int[][] notat) {
		for (int i = 0; i < notat.length; i++) {
			System.out.print("Studenti " + (i + 1) + ": ");
			for (int j = 0; j < notat[0].length; j++) {
				System.out.print(" " + notat[i][j]);
			}
			System.out.println();
		}
	}

	public static double[] mesatareStudent(int[][] notat) {
		double[] mesatare = new double[notat.length];

		for (int i = 0; i < notat.length; i++) {
			int shuma = 0;
			for (int j = 0; j < notat[i].length; j++) {
				shuma += notat[i][j];
			}
			mesatare[i] = (shuma / notat[i].length);
		}
		return mesatare;
	}

	public static double gjejMesatarenMaksimale(double[] arrMesatare) {
		double mesatarjaMaksimale = arrMesatare[0];
		for (int i = 1; i < arrMesatare.length; i++) {
			if (arrMesatare[i] > mesatarjaMaksimale) {
				mesatarjaMaksimale = arrMesatare[i];
			}
		}
		return mesatarjaMaksimale;
	}

	public static void main(String[] args) {
		int[][] arrNota = { { 5, 6, 7, 8, 9 }, { 6, 6, 7, 8, 9 }, { 7, 7, 8, 9, 10 }, { 9, 8, 9, 8, 7 },
				{ 8, 8, 8, 9, 8 }, { 5, 5, 5, 5, 5 }, { 7, 8, 9, 5, 5 }, { 7, 8, 7, 7, 7 }, { 9, 9, 9, 7, 7 },
				{ 5, 5, 5, 5, 10 } };

		printoNotat(arrNota);
		System.out.println("----------------------------");
		System.out.println("Mesatarja me e larte eshte : " + gjejMesatarenMaksimale(mesatareStudent(arrNota)));
	}
}