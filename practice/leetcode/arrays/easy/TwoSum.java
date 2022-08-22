package practice.hackerrank.arrays.easy;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];
        Map<Integer, String> map = IntStream.range(0, nums.length).boxed()
                .collect(Collectors.toMap(Function.identity(), k -> Function.identity() + ""));
        System.out.println(map.get(0));
        for (Integer i = 0; i < nums.length; i++) {
            String foundFirstNumberValue = map.get(target - nums[i]);
            if (foundFirstNumberValue != null) {
                resultArray[0] = target - nums[i];
                resultArray[1] = i;
                break;
            }
        }
        return resultArray;
    }

}

public class HourGlassSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = bufferedReader.read();
        int[] ar = new int[n];
        for (Integer i = 0; i < n; i++) {
            ar[i] = bufferedReader.read();
        }
        int result = Result.twoSum(arr);


        bufferedReader.close();
    }
}