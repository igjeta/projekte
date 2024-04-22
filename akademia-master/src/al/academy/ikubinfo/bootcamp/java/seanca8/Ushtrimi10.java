package al.academy.ikubinfo.bootcamp.java.seanca8;

public class Ushtrimi10 {

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
}
