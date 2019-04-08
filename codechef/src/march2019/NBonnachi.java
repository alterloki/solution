package march2019;

import java.util.Scanner;

public class NBonnachi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        int[] sum = new int[n + 1];
        int prev = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                prev = sum[i - 1];
            }
            sum[i] = prev ^ f[i];
        }
        int[] k = new int[q];
        for(int i = 0; i < q; i++) {
            k[i] = scanner.nextInt();
        }
        scanner.close();
        solve(n, q, sum, k);
    }

    private static void solve(int n, int q, int[] sum, int[] k) {
        for(int i = 0; i < q; i++) {
            int cur = (k[i] - 1) % (n + 1);
            System.out.println(sum[cur]);
        }
    }
}
