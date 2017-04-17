package mathematics;

import java.util.Scanner;

/**
 * @author ashevenkov 17.04.17 23:04.
 */
public class ReverseGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(n, k);
        }

    }

    private static void solve(int n, int k) {
        int result = 0;
        if(k < n / 2) {
            result = 2 * k + 1;
        } else {
            result = 2 * (n - 1 - k);
        }
        System.out.println(result);
    }
}
