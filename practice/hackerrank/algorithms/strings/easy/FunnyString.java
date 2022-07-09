
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
        // Write your code here
        List<Integer> sString = new ArrayList<>();
        List<Integer> rString = new ArrayList<>();
        String result = "Not Funny";
        for (Integer i = 0, j = s.length() - 1; i < s.length() - 1 && j > 1; i++, j--) {
            sString.add(Math.abs(((int) s.charAt(i)) - ((int) s.charAt(i + 1))));
            rString.add(Math.abs(((int) s.charAt(j)) - ((int) s.charAt(j - 1))));
        }
        if (sString.equals(rString))
            result = "Funny";
        return result;
    }

}

public class FunnyString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.funnyString(s);

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
