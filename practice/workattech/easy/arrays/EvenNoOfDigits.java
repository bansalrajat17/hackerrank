import java.util.ArrayList;
import java.util.List;

public class EvenNoOfDigits {
    List<Integer> getEvenDigitNumbers(int[] arr) {
        // add your logic here
        List<Integer> arrList = new ArrayList<>();
        for (Integer i = 0; i < arr.length; i++) {
            if ((arr[i] + "").length() % 2 == 0) {
                arrList.add(arr[i]);
            }
        }
        return arrList;
    }
}
