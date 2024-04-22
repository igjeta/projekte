package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi2 {

	public static int[] renditArray(int[] arr, boolean flag) {
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
		if (flag != true) { // nqs vlera e flag vjen false array lart qe u rentit nga me i vogli te me i
							// madhi behet reverse
			return reverseArray(arr);
		} else {
			return arr;
		}

	}

	public static int[] reverseArray(int[] reverse) {
		int i = 0;
		int j = reverse.length - 1;

		while (i < j) {
			int temp = reverse[i];
			reverse[i] = reverse[j];
			reverse[j] = temp;
			i++;
			j--;
		}
		return reverse;
	}
}