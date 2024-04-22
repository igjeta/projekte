package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class TemaModulit {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Shkruani numrin e seances per modulin e pare: ");

		int numerSeance = input.nextInt();

		switch (numerSeance) {
		case 1:
			System.out.println("Introduction to Java.(Installation etc) variables, primitive data types, operatoret");
			break;
		case 2:
			System.out.println("lab (1 ore ) control statements and loops, switch (2 ore)");
			break;
		case 3:
			System.out.println("Pune e pavarur");
			break;
		case 4:
			System.out.println("OOP 1 (2 ore) Lab (1 ore)");
			break;
		case 5:
			System.out.println("Lab (1 ore) OOP 2 (2 ore)");
			break;
		case 6:
			System.out.println("Lab");
			break;
		case 7:
			System.out.println("Pune e pavarur");
			break;
		case 8:
			System.out.println("Java API");
			break;
		case 9:
			System.out.println("Lab");
			break;
		case 10:
			System.out.println("Streams, lambdas, lab(1 ore)");
			break;
		case 11:
			System.out.println("Pune e pavarur");
			break;
		case 12:
			System.out.println("Exceptions,annotations. Introduction to files");
			break;
		case 13:
			System.out.println("Lab");
			break;
		case 14:
			System.out.println("Pune e pavarur (2 ore) Provim (1 ore)");
			break;
		default:
			System.out.println("Moduli i parë nuk përmban një temë për seancën që ju kërkuat!");
		}

	}
}
