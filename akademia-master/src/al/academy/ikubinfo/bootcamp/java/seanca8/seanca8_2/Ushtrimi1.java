package al.academy.ikubinfo.bootcamp.java.seanca8.seanca8_2;

public class Ushtrimi1 {
	
	public int[] findRecurringElements(int element, int[] array) {
		  int numerues = 0;

	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == element) {
	            	numerues++;
	            }
	        }

	        int[] pozicionet = new int[numerues];
	        int tempIndex = 0;

	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == element) {
	            	pozicionet[tempIndex] = i;
	            	tempIndex++;
	            }
	        }

	        return pozicionet;
	}

}
