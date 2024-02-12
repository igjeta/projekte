package al.academy.ikubinfo.bootcamp.java.seanca4;

import java.util.Scanner;

public class Minuta {

	public static long llogaritVite(long minuta) {

		return minuta / (365 * 24 * 60);
	}

	public static long llogaritDite(long minuta) {
		return minuta / (24 * 60);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Vendosni numri e minutave");

		long minuta = input.nextLong();

		System.out.println("Per " + minuta + " minuta ka " + llogaritDite(minuta) + " dite dhe " + llogaritVite(minuta)
				+ " vite.");

	}

}
