package y2015.r1; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 28.03.15
 * Time: 19:25
 */

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ProblemC {

    private static final int CONST = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] stools = new int[2 * n];
            for (int j = 0; j < stools.length; j++) {
                stools[j] = scanner.nextInt();
            }
            System.out.println(solve(stools, n));
        }
    }

    private static int solve(int[] stools, int n) {
        //[prev type][m][f]
        int[][][] state = new int[n + 1][n + 1][2 * n];
        state[0][0][0] = n;
        for (int mi = 0; mi < n; mi++) {
            for (int fi = 0; fi < n; fi++) {
                for (int i = 0; i < 2 * n; i++) {
                    if (i == 0) {
                        state[mi][fi][i] = n;
                    } else {
                        if (stools[i] == 1 && mi > 0) {
                            state[mi][fi][i] = state[mi - 1][fi][i - 1] * (n - mi) % CONST;
                        } else if (stools[i] == 2 && fi > 0) {
                            state[mi][fi][i] = state[mi][fi - 1][i - 1] * fi % CONST;
                        } else {
                            if (mi > 0) {
                                state[mi][fi][i] += state[mi - 1][fi][i - 1] * mi % CONST;
                            }
                            if (fi > 0) {
                                state[mi][fi][i] += state[mi][fi - 1][i - 1] * fi % CONST;
                            }
                        }
                    }
                }
            }
        }
        return state[n][n][2 * n - 1];
    }
}
