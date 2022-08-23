public class MergeTwoSortedArrays {
    static int[] mergeSortedArrays(int[] A, int[] B) {
        // add your logic here
        // add your logic here
        int cLength = A.length + B.length;
        int[] C = new int[cLength];
        int[] temp;
        if (B.length < A.length) {
            temp = A;
            A = B;
            B = temp;
        }
        Integer i = 0;
        Integer j = 0;
        Integer k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j])
                C[k++] = B[j++];
            else if (A[i] == B[j]) {
                C[k++] = A[i++];
                C[k++] = B[j++];
            } else
                C[k++] = A[i++];
        }
        // PUTTING REST OF THE ELEMENT IN LIST C
        while (j < B.length) {
            C[k++] = B[j++];
        }
        while (i < A.length) {
            C[k++] = A[i++];
        }
        return C;

    }

    public static void main(String args[]) {
        int[] A = { 1, 2, 3, 4, 4 };
        int[] B = { 2, 4, 5, 5 };

        int[] C = mergeSortedArrays(A, B);
        System.out.println(C);
    }
}
