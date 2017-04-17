package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ashevenkov 10.04.17 12:38.
 */
public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = initMap(magazine);
        noteMap = initMap(note);
    }

    private Map<String, Integer> initMap(String s) {
        Map<String, Integer> result = new HashMap<>();
        String[] parts = s.split(" ");
        for (String part : parts) {
            Integer count = result.get(part);
            if(count == null) {
                count = 0;
            }
            count++;
            result.put(part, count);
        }
        return result;
    }

    public boolean solve() {
        for (Map.Entry<String, Integer> noteEntry : noteMap.entrySet()) {
            int noteCount = noteEntry.getValue() == null ? 0 : noteEntry.getValue();
            Integer magazineCount = magazineMap.get(noteEntry.getKey());
            magazineCount = magazineCount == null ? 0 : magazineCount;
            if(magazineCount < noteCount) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
