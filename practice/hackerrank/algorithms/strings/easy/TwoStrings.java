import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s1
     * 2. STRING s2
     */

    public static boolean twoStrings(String s1, String s2) {
        // Write your code
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        boolean[] q = new boolean[256];
        for (char c : a) {
            q[c] = true;
        }

        for (char c : b) {
            if (q[c])
                return true;
        }
        return false;
    }
}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = (Result.twoStrings(s1, s2)) ? "YES" : "NO";

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
