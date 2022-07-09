import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class SpecialStringAgain {
    static List<String> substringSets(String s) {
        List<String> subStringList = new ArrayList<>();
        for (Integer i = 0; i < s.length(); i++) {
            for (Integer k = i + 1; k < s.length(); k++) {
                subStringList.add(s.substring(i, k));
            }
        }
        return subStringList;
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        List<String> substringList = substringSets(s);
        if (n % 2 != 0) {
            int substringListSize = substringList.size();
            for (Integer i = 0; i < substringListSize; i++) {
                String substring = substringList.get(i);
                int substrn = substring.length();
                if (substrn > 1) {
                    int m = (substrn + 1) / 2;
                    substring = substring.substring(0, m) + substring.substring(m + 1);
                    Set<Character> charList = substring.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                    Set<String> stringSet = new HashSet<>();
                }
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
