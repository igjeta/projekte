package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class PerseritMeesazhin {

	public static void main(String[] args) {

		Scanner input= new Scanner(System.in);
		
		System.out.println("Vendosni numrin sa here doni te perseritet mesazhi");
		
		int numerPerseritjesh=input.nextInt();
		
		do {
			System.out.println("Mire se erdhe në programin e Java Bootcamp");
			numerPerseritjesh--;
		}while(numerPerseritjesh!=0);
	}

}
