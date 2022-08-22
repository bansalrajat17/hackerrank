import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        List<String> sList = new ArrayList<>();
        Integer count = 0;
        for (Integer i = 0; i < s.length(); i++) {
            for (Integer j = i + 1; j < s.length(); j++) {
                sList.add(s.substring(i, j));
            }
        }
        int k = 0;
        while (k < (sList.size() - k - 1)) {

            if (sList.get(k).equals(sList.get(sList.size() - k - 1))) {
                count++;
            }
            k++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int count = sherlockAndAnagrams(s);
        System.out.println(count);

    }
}
