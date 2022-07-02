package greedyalgorithm.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
     
     public static Boolean isSorted(List<String> rotatedList)
     {
         for(Integer i = 0 ; i < rotatedList.size() ; i++)
         {
             String s = rotatedList.get(i);
             char[] sArray = s.toCharArray();
             for(Integer j = 0 ; j < sArray.length-1 ; j++)
             {                 
                    if(sArray[j] > sArray[j+1])
                        return false;                 
             }
         }
         return true;
     }

    public static String gridChallenge(List<String> grid) {
    // Write your code here
    Integer stringLength = grid.get(0).length();
    for(Integer i = 0 ; i < grid.size() ; i++)
    {
        grid.set(i, grid.get(i).chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());     
    }
    List<String> rotatedList = new ArrayList<>();
    Integer l = 0;
    for(Integer j = 1 ; j < stringLength ; j++)
    {
        String s = ""; 
        for(Integer k = 0 ; k < grid.size() ; k++)
        {
            s += grid.get(k).substring(l, j); 
        }
        rotatedList.add(s);
        l++;
    }
    Boolean isSorted = isSorted(rotatedList);
    return isSorted?"YES":"NO";

    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}