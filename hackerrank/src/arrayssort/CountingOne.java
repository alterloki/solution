/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 09.01.15
 * Time: 23:32
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CountingOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        solve(ar);
    }

    private static void solve(int[] ar) {
        int[] result = new int[100];
        for (int i = 0; i < ar.length; i++) {
            int a = ar[i];
            result[a]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            int r = result[i];
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(r);
        }
        System.out.println(sb.toString());
    }
}
