
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NoOfGemstones {
    public static int gemstones(List<String> arr) {
        final long startTime = System.nanoTime();
        // Write your code here
        Optional<String> minOptional = arr.stream()
                .reduce((a, b) -> (a.length() > 0 && a.length() <= b.length() ? a : b));
        Integer noOfGemstones = 0;
        arr = arr.stream().filter(a -> !a.equals("")).collect(Collectors.toList());
        if (minOptional.isPresent()) {
            String min = minOptional.get().trim();
            min = min.chars().mapToObj(ch -> (char) ch).distinct().map(c -> c.toString()).collect(Collectors.joining());
            for (Integer i = 0; i < min.length(); i++) {
                boolean flag = Boolean.TRUE;
                for (Integer j = 0; j < arr.size(); j++) {
                    if (arr.get(j).indexOf(min.charAt(i)) == -1) {
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                if (Boolean.TRUE.equals(flag)) {
                    noOfGemstones++;
                }
            }
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println("Time taken" + duration / 1000);
        return noOfGemstones;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        List<String> s = new ArrayList<>();
        for (Integer i = 0; i < n; i++) {
            s.add(scanner.nextLine());
        }
        int k = gemstones(s);
        System.out.println("GEMSTONE" + k);
    }
}
