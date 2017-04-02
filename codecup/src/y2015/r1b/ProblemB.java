package y2015.r1b;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] k = new int[n][];
            for (int j = 0; j < n; j++) {
                k[j] = new int[2*(j + 1)];
                for(int a = 0; a < 2*(j + 1); a++) {
                    k[j][a] = scanner.nextInt();
                }
            }
            System.out.println(solve(n, k));
        }

    }

    private static double solve(int n, int[][] k) {
        double[][] p = new double[n + 1][n + 1];
        double[][] m = new double[n + 1][n + 1];
        p[0][0] = 1;
        m[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int d1 = k[i][2 * j];
                int d2 = k[i][2 * j + 1];
                if (d1 == d2) {
                    p[i + 1][j] += p[i][j] * 0.5;
                    p[i + 1][j + 1] += p[i][j] * 0.5;
                    m[i + 1][j] += (m[i][j] + d1 * p[i][j]) * 0.5;
                    m[i + 1][j + 1] += (m[i][j] + d2 * p[i][j]) * 0.5;
                } else if (d1 > d2) {
                    p[i + 1][j + 1] += p[i][j];
                    m[i + 1][j + 1] += m[i][j] + d2 * p[i][j];
                } else {
                    p[i + 1][j] += p[i][j];
                    m[i + 1][j] += m[i][j] + d1 * p[i][j];
                }

            }
        }
        double sum = 0;
        for(int i = 0; i < n + 1; i++) {
            sum += m[n][i];
        }
        return sum;
    }
}
