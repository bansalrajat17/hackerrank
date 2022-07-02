package practice.hackerrank.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        // Write your code here
        char[] hackerrank = { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };
        String result = "YES";
        int count = 0;
        if (s.length() < hackerrank.length) {
            result = "NO";// BASE CASE.
        }
        for (Integer i = 0; i < hackerrank.length; i++) {
            int in = s.indexOf(hackerrank[i]);
            if (in >= 0) {
                s = s.substring(in + 1);
                count++;
            } else
                break;
        }
        if (count != hackerrank.length)
            result = "NO";
        return result;

    }
}

public class HackerRankInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

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
