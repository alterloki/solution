package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 22:30.
 */
public class BitwiseAnd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            solve(n, k);
        }
    }

    private static void solve(int n, int k) {
        int max = 0;
        for(int a = 1; a < n; a++) {
            for(int b = a + 1; b <= n; b++) {
                int t = a & b;
                if(t < k && max < t) {
                    max = t;
                }
            }
        }
        System.out.println(max);
    }
}
