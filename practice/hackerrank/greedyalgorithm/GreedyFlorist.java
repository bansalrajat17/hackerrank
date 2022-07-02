package practice.hackerrank.greedyalgorithm;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c, int p, int cost) {
        int clength = c.length;
        List<Integer> cList = Arrays.stream(c).boxed().collect(Collectors.toList());
        if (clength == 1) {
            cost += (p > 1) ? c[0] * p : c[0];
        } else if (clength == k) {
            cost += cList.stream().map(b -> b * p).reduce(0, Integer::sum);
        } else {
            Collections.sort(cList, Collections.reverseOrder());
            cost += cList.subList(0, k).stream().map(b -> b * p).reduce(0, Integer::sum);
            List<Integer> remainingSubList = cList.subList(k, cList.size());
            System.out.println(remainingSubList);
            while (remainingSubList.size() > 0) {
                cost += getMinimumCost(k, remainingSubList.stream().mapToInt(Integer::intValue).toArray(), p + 1, cost);
            }
        }
        return cost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
          BufferedWriter bufferedWriter = new BufferedWriter(new
          FileWriter(System.getenv("OUTPUT_PATH")));
          
          String[] nk = scanner.nextLine().split(" ");
          
          int n = Integer.parseInt(nk[0]);
          
          int k = Integer.parseInt(nk[1]);
          
          int[] c = new int[n];
          
          String[] cItems = scanner.nextLine().split(" ");
          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
          
          for (int i = 0; i < n; i++) {
          int cItem = Integer.parseInt(cItems[i]);
          c[i] = cItem;
          }
          
          int minimumCost = getMinimumCost(k, c, 1,0);
          
          bufferedWriter.write(String.valueOf(minimumCost));
          bufferedWriter.newLine();
          
          bufferedWriter.close();
          
          scanner.close();
         
    }
}
