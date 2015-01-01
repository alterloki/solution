/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 02.01.15
 * Time: 0:19
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < a.length; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(a));
        }
    }

    private static String solve(int[] a) {
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            prev = gcd(prev, a[i]);
            if(prev == 1) {
                return "YES";
            }
        }
        return "NO";
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
