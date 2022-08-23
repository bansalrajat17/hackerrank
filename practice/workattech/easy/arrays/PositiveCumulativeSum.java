import java.util.ArrayList;
import java.util.List;

class PositiveCumulativeSum {
    List<Integer> getPositiveCumulativeSum(int[] arr) {
        // add your logic here
        List<Integer> arrList = new ArrayList<>();
        Integer result = arr[0];
        if (result > 0)
            arrList.add(result);
        if (arr.length > 1) {
            for (Integer i = 1; i < arr.length; i++) {
                arr[i] += result;
                result = arr[i];
                if (result > 0)
                    arrList.add(result);
            }
        }
        return arrList;
    }
}
