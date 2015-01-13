/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 23:55
 */
package implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockQueries {

    private static final long BILLION = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[m];
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            c[i] = scanner.nextInt();
        }
        solve(a, b, c);
    }

    private static void solve(long[] a, int[] b, int[] c) {
        long[] bval = new long[100001];
        Arrays.fill(bval, 1);
        for (int i = 0; i < b.length; i++) {
            bval[b[i]] = (bval[b[i]] * c[i]) % BILLION;
        }
        int prevB = 0;
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            if (b[i] != prevB) {
                int curB = b[i];
                while (curB <= a.length) {
                    a[curB - 1] = (a[curB - 1] * bval[b[i]]) % BILLION;
                    curB += b[i];
                }
            }
            prevB = b[i];
        }
        printArr(a);
    }

    private static void printArr(long[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }
}
