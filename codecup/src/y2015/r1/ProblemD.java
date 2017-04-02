package y2015.r1; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 28.03.15
 * Time: 20:03
 */

import java.util.*;

/**
 * @author ashevenkov
 */
public class ProblemD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        String line = scanner.next();
        int m = scanner.nextInt();
        int[] p = new int[m];
        int[] d = new int[m];
        for(int i = 0; i < m; i++) {
            p[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }
        solve(a, b, c, line, p, d);
    }

    private static void solve(int a, int b, int c, String line, int[] p, int[] d) {
        Set<String> set = new HashSet<>();
        fillInitial(set, a, b, c);
        Set<Integer> positions = new HashSet<>();
        positions.add(0);
        while(!positions.isEmpty()) {

        }
    }

    private static void fillInitial(Set<String> set, int a, int b, int c) {
        for(int i = 0; i <= 9; i++) {
            set.add(Integer.toString(a * i * i + b * i + c));
        }
    }
}
