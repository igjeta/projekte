package al.academy.ikubinfo.bootcamp.java.seanca8;

public class GjejMax {

	public static int gjejMaxMesDyNumrave(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}

	public static int gjejMaxMesTreNumrave(int num1, int num2, int num3) {
		if (gjejMaxMesDyNumrave(num1, num2) > num3) {
			return gjejMaxMesDyNumrave(num1, num2);
		} else {
			return num3;
		}
	}

	public static int gjejMaxMesKaterNumrave(int num1, int num2, int num3, int num4) {
		if (gjejMaxMesTreNumrave(num1, num2, num3) > num4) {
			return gjejMaxMesTreNumrave(num1, num2, num3);
		} else {
			return num4;
		}
	}

	public static void main(String[] args) {
		int numer1 = 4;
		int numer2 = 6;
		int numer3 = 12;
		int numer4 = 18;

		System.out.println("Max mes dy numrave " + gjejMaxMesDyNumrave(numer1, numer2));

		System.out.println("Max mes tre numrave " + gjejMaxMesTreNumrave(numer1, numer2, numer3));

		System.out.println("Max mes kater numrave " + gjejMaxMesKaterNumrave(numer1, numer2, numer3, numer4));

	}

}
