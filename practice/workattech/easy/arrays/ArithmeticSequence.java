import java.util.Arrays;

public class ArithmeticSequence {
    boolean isArithmeticSequence(int[] arr) {
        // add your logic here
        boolean isArithmeticSequence = true;
        Arrays.sort(arr);
        Integer d = arr[1] - arr[0];
        for (Integer i = arr.length - 1; i >= 1; i--) {
            if (arr[i] - arr[i - 1] != d) {
                isArithmeticSequence = false;
            }
        }
        return isArithmeticSequence;
    }
}
