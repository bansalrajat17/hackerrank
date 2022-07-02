package practice.hackerrank.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here
        char[] sArray = s.toCharArray();
        Stack<Character> c = new Stack<>();
        c.push(sArray[0]);
        for (Integer i = 1; i < sArray.length; i++) {
            if (c.size() > 0) {
                if (c.peek() == sArray[i])
                    c.pop();
                else
                    c.push(sArray[i]);
            } else {
                c.push(sArray[i]);
            }
        }
        String sResult = (c.toString().substring(1, (c.toString().length() - 1)).replaceAll(",", "").replaceAll(" ",
                ""));
        if (sResult.isEmpty())
            sResult = "Empty String";
        return sResult;
    }

}

public class ReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
