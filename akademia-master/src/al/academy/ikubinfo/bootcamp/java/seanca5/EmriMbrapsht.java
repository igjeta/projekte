package al.academy.ikubinfo.bootcamp.java.seanca5;

import java.util.Scanner;

public class EmriMbrapsht {

	public static String emriMbrapsht(String emer) {
		String mbrapsht = "";
		char ch;

		for (int i = 0; i < emer.length(); i++) {
			ch = emer.charAt(i);
			mbrapsht = ch + mbrapsht;
		}
		return mbrapsht;
	}

	public static boolean eshtePalindrome(String emer) {
		String emerMbrapsht = emriMbrapsht(emer);
		if (emerMbrapsht.equals(emer)) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Shkruani emrin tuaj :");

		String emer = input.next();

		System.out.println("Emri juaj mbrapsht eshte : " + emriMbrapsht(emer));

		System.out.println("Emri eshte palindrome? " + eshtePalindrome(emer));

	}
}