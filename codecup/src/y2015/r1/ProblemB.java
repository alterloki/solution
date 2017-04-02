package y2015.r1; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 28.03.15
 * Time: 19:39
 */

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            String x = scanner.next();
            String y = scanner.next();
            String z = scanner.next();
            System.out.println(solve(x, y, z));
        }
    }

    private static String solve(String x, String y, String z) {
        int[] xa = toIntArr(x);
        int[] ya = toIntArr(y);
        int[] za = toIntArr(z);
        for(int i = 0; i < 200; i++) {
            int sum = 0;
            for(int j = 0; j <= i; j++) {
                sum += xa[j] * ya[i - j];
            }
            if(sum != za[i]) {
                return "Finite";
            }
        }
        return "Infinity";
    }

    private static int[] toIntArr(String a) {
        int[] res = new int[200];
        char[] ca = a.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            res[i] = ca[ca.length - i - 1] - '0';
        }
        return res;
    }
}
