import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        List<String> resultantList = new ArrayList<>();
        int ascii = 0;
        int[] aList = new int[s.length()];
        for (Integer i = 0; i < s.length(); i++) {
            aList[i] = ((s.charAt(i))) - 96;
            if ((s.charAt(i)) == ascii) {
                aList[i] = aList[i] + aList[i - 1];
            }
            ascii = (s.charAt(i));
        }
        Set<Integer> ary = Arrays.stream(aList).boxed().collect(Collectors.toSet());
        queries.forEach(query -> {
            if (ary.contains(query))
                resultantList.add("Yes");
            else
                resultantList.add("No");
        });
        return resultantList;

    }

}

public class WeightedUniformStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
 * FACING TLE(TIME LIMIT EXCEEDED)
 * enum alphabets {
 * a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8), i(9), j(10), k(11), l(12),
 * m(13), n(14), o(15), p(16), q(17),
 * r(18),
 * s(19), t(20), u(21), v(22), w(23), x(24), y(25), z(26);
 * 
 * int value;
 * 
 * alphabets(int value) {
 * this.value = value;
 * }
 * }
 * 
 * class Result {
 * 
 * public static Boolean isAllCharSame(String s) {
 * Set<Character> charSet = new HashSet<>();
 * for (Integer i = 0; i < s.length(); i++) {
 * charSet.add(s.charAt(i));
 * }
 * if (charSet.size() == 1)
 * return Boolean.TRUE;
 * return Boolean.FALSE;
 * }
 * 
 * public static List<String> getUniformStrings(String s) {
 * List<String> uniformSubstrings = new ArrayList<>();
 * for (Integer i = 0; i < s.length(); i++) {
 * for (Integer j = i + 1; j < s.length(); j++) {
 * String substring = s.substring(i, j);
 * if (substring.length() == 1 || isAllCharSame(substring)) {
 * uniformSubstrings.add(substring);
 * }
 * }
 * }
 * return uniformSubstrings;
 * }
 * 
 * 
 * 
 * 
 * public static List<String> weightedUniformStrings(String s, List<Integer>
 * queries) {
 * // Write your code here\
 * List<String> resultantList = new ArrayList<>();
 * 
 * List<String> uniformStringList = getUniformStrings(s);
 * Map<String, Integer> weightedUniformStringMap = new HashMap<>();
 * uniformStringList.forEach(uniformString -> {
 * weightedUniformStringMap.put(uniformString, calculateWeight(uniformString));
 * });
 * 
 * queries.forEach(query -> {
 * if (weightedUniformStringMap.containsValue(query)) {
 * resultantList.add("YES");
 * } else
 * resultantList.add("NO");
 * });
 * return resultantList;
 * 
 * }
 * 
 * }
 * 
 * public class WeightedUniformStrings {
 * public static void main(String[] args) throws IOException {
 * BufferedReader bufferedReader = new BufferedReader(new
 * InputStreamReader(System.in));
 * BufferedWriter bufferedWriter = new BufferedWriter(new
 * FileWriter(System.getenv("OUTPUT_PATH")));
 * 
 * String s = bufferedReader.readLine();
 * 
 * int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
 * 
 * List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
 * try {
 * return bufferedReader.readLine().replaceAll("\\s+$", "");
 * } catch (IOException ex) {
 * throw new RuntimeException(ex);
 * }
 * })
 * .map(String::trim)
 * .map(Integer::parseInt)
 * .collect(toList());
 * 
 * List<String> result = Result.weightedUniformStrings(s, queries);
 * 
 * bufferedWriter.write(
 * result.stream()
 * .collect(joining("\n"))
 * + "\n");
 * 
 * bufferedReader.close();
 * bufferedWriter.close();
 * }
 * }
 */
