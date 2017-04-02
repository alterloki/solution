/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 20:22
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CountingTwo {

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
            if (r > 0) {
                for(int j = 0; j < r; j++) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
        }
        String resultString = sb.toString();
        System.out.println(resultString.substring(0, resultString.length() - 1));
    }
}
