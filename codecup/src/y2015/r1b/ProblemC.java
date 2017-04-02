package y2015.r1b;

import java.util.Scanner;

/**
 * Created by ashevenkov on 25.04.15.
 */
public class ProblemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(a));
        }
    }

    private static double solve(int[] a) {
        double max = a[0];

        return 0;
    }
}
