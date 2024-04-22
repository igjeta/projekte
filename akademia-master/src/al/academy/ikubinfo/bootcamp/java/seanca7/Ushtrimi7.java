package al.academy.ikubinfo.bootcamp.java.seanca7;

public class Ushtrimi7 {

	public static boolean krahasoArrayt(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}

		renditArray(arr1);
		renditArray(arr2);

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[] renditArray(int[] arr) {
		boolean perfundoj = false;
		while (!perfundoj) {
			perfundoj = true;
			for (var i = 1; i < arr.length; i += 1) {
				if (arr[i - 1] > arr[i]) {
					perfundoj = false;
					int tmp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = tmp;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {

		int[] arr1 = { 4, 7, 8, 8, 9 };
		int[] arr2 = { 7, 8, 4, 9, 8 };

		if (krahasoArrayt(arr1, arr2)) {
			System.out.println("Arrayt jane te barabarte!");
		} else {
			System.out.println("Arrayt nuk jane te barabarte!");
		}

	}

}
