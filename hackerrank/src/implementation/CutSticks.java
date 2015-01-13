/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 23:01
 */
package implementation;

import java.util.*;

/**
 * @author ashevenkov
 */
public class CutSticks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        solve(list);
    }

    private static void solve(List<Integer> list) {
        int removed = list.size();
        while (removed > 0) {
            int min = findMin(list);
            removed = 0;
            for (int i = 0; i < list.size(); i++) {
                Integer value = list.get(i);
                if (value > 0) {
                    int newValue = value - min;
                    list.set(i, newValue);
                    removed++;
                }
            }
            if (removed > 0) {
                System.out.println(removed);
            }
        }
    }

    private static int findMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i > 0 && i < min) {
                min = i;
            }
        }
        return min;
    }
}
