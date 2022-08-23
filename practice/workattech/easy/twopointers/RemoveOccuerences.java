import java.util.ArrayList;
import java.util.List;

public class RemoveOccuerences {
    int[] removeElement(int[] A, int index) {
        if (index < 0 || index >= A.length || A == null) {
            return A;

        }        
        int[] arrayAfterRemovingElement = new int[A.length - 1];
        System.arraycopy(A, 0, arrayAfterRemovingElement, 0, index);
        System.arraycopy(A, index + 1, arrayAfterRemovingElement, index, A.length - index - 1);
        return arrayAfterRemovingElement;
    }

    int removeOccurences(int[] A, int k) {
        // add your logic here
        for (Integer i = 0; i < A.length; i++) {
            if (k == A[i]) {
                int oldArrayLength = A.length;
                A = removeElement(A, i);
                int newArrayLength = A.length;
                if (oldArrayLength > newArrayLength)
                    i = -1;
            }
        }
        return A.length;
    }

}
