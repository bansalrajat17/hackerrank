package practice.hackerrank.strings.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    public static Boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return (stringBuilder.reverse().toString().equals(s)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER n
     * 3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here
        StringBuilder sBuilder = new StringBuilder(s);
        if (n == 1)
            sBuilder = new StringBuilder("9");
        else {
            for (Integer i = 0; i < n / 2 && k > 0; i++) {
                if (sBuilder.charAt(i) != '9' && sBuilder.charAt(n - 1 - i) == '9' && k >= 1) {
                    sBuilder.setCharAt(i, '9');
                    k--;
                } else if (sBuilder.charAt(n - 1 - i) != '9' && sBuilder.charAt(i) == '9' && k >= 1) {
                    sBuilder.setCharAt(n - 1 - i, '9');
                    k--;
                } else if (sBuilder.charAt(i) != '9' && sBuilder.charAt(n - 1 - i) != '9' && k >= 2) {
                    sBuilder.setCharAt(i, '9');
                    sBuilder.setCharAt(n - 1 - i, '9');
                    k -= 2;
                } else if (k == 1 && sBuilder.charAt(n - 1 - i) != sBuilder.charAt(i)) {
                    if (sBuilder.charAt(n - 1 - i) != '9')
                        sBuilder.setCharAt(i, sBuilder.charAt(n - 1 - i));
                    else
                        sBuilder.setCharAt(n - 1 - i, sBuilder.charAt(i));
                    k--;
                }
            }
        }
        if (k > 0 && n % 2 != 0) // IF LENGTH OF THE STRING IS ODD
            sBuilder.setCharAt(n / 2, '9');
        return Boolean.TRUE.equals((isPalindrome(sBuilder.toString()))) ? sBuilder.toString() : "-1";
    }
}

public class HighestValuePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
