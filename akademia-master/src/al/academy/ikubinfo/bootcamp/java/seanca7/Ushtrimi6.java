package al.academy.ikubinfo.bootcamp.java.seanca7;

public class Ushtrimi6 {

	public static int numriDyteMaksimal(int[] arr) {
		if (arr.length < 2) {
			return Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE;
		int maxDy = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				maxDy = max;
				max = arr[i];
			} else if (arr[i] > maxDy && arr[i] != max) {
				maxDy = arr[i];
			}
		}

		return maxDy;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 32, 6, 1, 67, 45 };

		System.out.println("Numri i dyte me i madh eshte: " + numriDyteMaksimal(arr));
	}

}
