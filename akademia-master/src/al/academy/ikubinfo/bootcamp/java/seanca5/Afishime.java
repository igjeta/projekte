package al.academy.ikubinfo.bootcamp.java.seanca5;

public class Afishime {

	public static void main(String[] args) {

		// kerkesa A
//		int rrjesht = 0;
//
//		while (rrjesht < 6) {
//			int kolona = 0;
//			while (j < 6) {
//				System.out.print("*");
//				kolona++;
//			}
//			System.out.println();
//			rrjesht++;
//		}

		// kerkesa B
//		int rrjesht = 1;
//
//		while (rrjesht < 6) {
//			int kolona = 0;
//			int formula = 2 * rrjesht - 1;
//			while (kolona < formula) {
//				System.out.print("*");
//				kolona++;
//			}
//			System.out.println();
//			rrjesht++;
//
//		}

		// kerkesa C
		int rrjesht = 1;
		int hapsireTotale = 4;
		int spaceTotal = 4;
		int rrjeshtaTotal = 5;

		while (rrjesht <= rrjeshtaTotal) {
			int space = 0;

			while (space < spaceTotal) {
				System.out.print(" ");
				space++;
			}
			int yje = 2 * rrjesht - 1;

			int numero = 0;
			while (numero < yje) {
				System.out.print("*");
				numero++;
			}
			System.out.println();
			spaceTotal--;
			rrjesht++;
		}

	}

}
