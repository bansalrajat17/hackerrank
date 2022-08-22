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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        List<Character> cha = new ArrayList<>();
        String result = "NO";
        if (s.length() == 1)
            result = "YES";

        else {
            while (s.length() >= 1) {
                char first = s.charAt(0);
                s = s.substring(1);
                int indexOf = s.indexOf(first);
                if (indexOf >= 0) {
                    s = (indexOf == 0) ? s.substring(indexOf + 1) : s.substring(0, indexOf) + s.substring(indexOf + 1);
                } else {
                    if (cha.isEmpty()) {
                        cha.add(first);
                        s = s.substring(indexOf + 1);
                    } else {
                        return "NO";
                    }
                }

            }
        }
        if (s.length() == 0 || s.length() == 1)
            result = "YES";

        return result;
    }

}

public class GameOfThronesI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
