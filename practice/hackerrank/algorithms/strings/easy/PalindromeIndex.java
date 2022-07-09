

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    public static Boolean isPallindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return (stringBuilder.reverse().toString().equals(s)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
        StringBuilder sBuilder = new StringBuilder(s);
        int resultantIndex = -1;
        if (isPallindrome(sBuilder.toString()))
            return -1;
        int length = sBuilder.length();
        for (Integer i = 0; i < length / 2; i++) {
            if (sBuilder.charAt(i) != sBuilder.charAt(length - 1 - i)) {
                if (isPallindrome(sBuilder.substring(i + 1, length - i))) {
                    resultantIndex = i;
                    break;
                } else {
                    if (isPallindrome(sBuilder.substring(i, length - i - 1))) {
                        resultantIndex = length - i - 1;
                        break;
                    }

                }

            }
        }
        return resultantIndex;
    }

}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
