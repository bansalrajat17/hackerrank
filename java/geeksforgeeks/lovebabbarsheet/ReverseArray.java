package java.geeksforgeeks.lovebabbarsheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReverseArray {
    public static void main(String[] args) {
        // code
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        for (Integer k = 0; k < T; k++) {
            Integer N = scanner.nextInt();
            List<Integer> nlist = new ArrayList<>();
            for (Integer i = 0; i < N; i++) {
                nlist.add(scanner.nextInt());
            }
            for (Integer j = N - 1; j >= 0; j--) {
                System.out.print(nlist.get(j));
                if (j != 0)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}