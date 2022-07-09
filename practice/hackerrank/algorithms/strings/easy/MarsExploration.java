import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    public static int SOSMatch(String s) {
        int count = 0;
        if (s.charAt(0) != 'S')
            count++;
        if (s.charAt(1) != 'O')
            count++;
        if (s.charAt(2) != 'S')
            count++;
        return count;
    }

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        // Write your code here
        int count = 0;
        int i = 0;
        while (i + 3 <= s.length()) {
            if (!s.substring(i, i + 3).equals("SOS")) {
                count += SOSMatch(s.substring(i, i + 3));
            }
            i += 3;

        }
        return count;
    }

}

public class MarsExploration {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
