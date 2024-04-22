package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi4 {

	public static int gjejPozElementinMinArray1D(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}

		int indexMinimum = 0;
		int minimum = arr[indexMinimum];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < minimum) {
				minimum = arr[i];
				indexMinimum = i;
			}
		}

		return indexMinimum;
	}

	public static int gjejPozElementinMinArray2D(int[][] arr) {
		if (arr.length == 0 || arr[0].length == 0) {
			return -1;
		}

		int indexMinimum = gjejPozElementinMinArray1D(arr[0]);
		int minElement = arr[0][indexMinimum - 1];

		for (int i = 1; i < arr.length; i++) {
			int tempMinPoz = gjejPozElementinMinArray1D(arr[i]);
			int tempMinElement = arr[i][tempMinPoz - 1];

			if (tempMinElement < minElement) {
				indexMinimum = tempMinPoz + (i * arr[0].length);
				minElement = tempMinElement;
			}
		}

		return indexMinimum;
	}
}