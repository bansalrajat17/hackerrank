import java.util.Arrays;
import java.util.Collections;

public class KthLargest {
    int getKthLargestElement(int[] list, int k) {
	    // add your logic here
		Integer[] newArray = new Integer[list.length];
		int i = 0;
		for (int value : list) {
    		newArray[i++] = Integer.valueOf(value);
		}
		Arrays.sort(newArray,Collections.reverseOrder());
		return newArray[k - 1];
	}
}
