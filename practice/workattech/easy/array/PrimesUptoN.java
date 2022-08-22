import java.util.ArrayList;
import java.util.List;

public class PrimesUptoN {
    boolean isPrimeNumber(int no) {
        boolean flag = false;
        for (Integer i = 2; i < no; i++) {
            if (no % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    List<Integer> primesUptoN(int n) {
        List<Integer> aList = new ArrayList<>();
        for (Integer i = 2; i <= n; i++) {
            if (!isPrimeNumber(i)) {
                aList.add(i);
            }
        }
        return aList;
    }
}
