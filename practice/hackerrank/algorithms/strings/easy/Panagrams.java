
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Panagrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        int count = 0, i, j;
        char temp;
        char str[] = s.toUpperCase().toCharArray();
        Set<Character> lis = new HashSet<Character>();
        int l = str.length;
        for (i = 0; i < l; i++) {
            if (str[i] != ' ')
                lis.add(str[i]);
        }
        count = lis.size();
        System.out.println(count);
        if (count == 26)
            return "pangram";
        else
            return "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = pangrams(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
