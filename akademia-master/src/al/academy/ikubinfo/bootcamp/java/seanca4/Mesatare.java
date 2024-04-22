package al.academy.ikubinfo.bootcamp.java.seanca4;

import java.util.Scanner;

public class Mesatare {

	static int llogaritMesatarePerPeseNumra(int nr1, int nr2, int nr3, int nr4, int nr5) {

		return (nr1 + nr2 + nr3 + nr4 + nr5) / 5;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Shkruani 5 numra te tipit int per te llogaritur mesataren e tyre");

		int numriPare = input.nextInt();
		int numriDyte = input.nextInt();
		int numriTrete = input.nextInt();
		int numriKatert = input.nextInt();
		int numriPeste = input.nextInt();

		System.out.println("Per numrat " + numriPare + ", " + numriDyte + ", " + numriTrete + ", " + numriKatert + ", "
				+ numriPeste + " te dhene nga perdoruesi, mesatarja aritmetike e tyre eshte : "
				+ llogaritMesatarePerPeseNumra(numriPare, numriDyte, numriTrete, numriKatert, numriPeste) + ".");

	}
}
