package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi0 {

	public static void printoArray2D(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Rrjeshti " + (i + 1) + ": ");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(" " + arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] arr1 = { { 9, 9 } };
		int[][] arr2 = { { 11, 11, 11 }, { 22, 22, 22 }, { 33, 33, 33 } };

		System.out.println("Array pare : ");
		printoArray2D(arr1);
		System.out.println("-------------------------");
		System.out.println("Array dyte : ");
		printoArray2D(arr2);

	}

}
