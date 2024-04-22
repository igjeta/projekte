package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi3 {

	public static int gjejNumrinMeTekMax(int[] arr) {
		int maxTek = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] > maxTek) {
				maxTek = arr[i];
			}
		}

		return maxTek;
	}

	public static int gjejNumrinCiftMax(int[] arr) {
		int maxCift = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0 && arr[i] > maxCift) {
				maxCift = arr[i];
			}
		}

		return maxCift;
	}

}
