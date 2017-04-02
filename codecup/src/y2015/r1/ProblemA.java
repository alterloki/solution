package y2015.r1; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 28.03.15
 * Time: 18:58
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ProblemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(new ProblemA().solve(n, l, a, b));
        }
    }

    private String solve(int n, int l, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int minSumA = 0;
        for(int i = 0; i < l; i++) {
            minSumA += a[i];
        }
        int maxSumB = 0;
        for(int i = 0; i < l;i++) {
            maxSumB += b[n - i - 1];
        }
        if(minSumA > maxSumB) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
