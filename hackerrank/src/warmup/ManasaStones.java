/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 01.01.15
 * Time: 23:44
 */
package warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ashevenkov
 */
public class ManasaStones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int a, int b) {
        if(n == 1) {
            return "0";
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            result.add(i * a + (n - i - 1) * b);
        }
        int[] aResult = toArray(result);
        Arrays.sort(aResult);
        return string(aResult);
    }

    private static int[] toArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int counter = 0;
        for (Integer i : set) {
            result[counter++] = i;
        }
        return result;
    }

    private static String string(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
