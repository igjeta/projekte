package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class ShumaDyNumrave {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean jepNumra = false;

		while (!jepNumra) {
			System.out.println("Shkruani dy numra (numri i pare i tipit int dhe numri i dyte i tipit double):");

			int numriPare = input.nextInt();
			double numriDyte = input.nextDouble();

			System.out.println("Shuma e numrit te pare "+numriPare+" dhe numrit te dyte "+numriDyte+" te dhene eshte " + (numriPare + numriDyte));

			System.out.println("Deshironi vazhdoni? shembull: 'jo' per te ndaluar ");
			
			String pergjigje=input.next();
			if(pergjigje.equals("jo")) {
				jepNumra=true;
			}
		}
		System.out.println("Falemnderit për inputet tuaja!");
	}

}
