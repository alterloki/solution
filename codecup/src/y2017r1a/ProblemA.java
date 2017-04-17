package y2017r1a;

import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(k, x, y));
        }
    }

    private static int solve(int k, int x, int y) {
        int winner = Math.max(x, y);
        int delta = Math.abs(x - y);
        if(winner >= k) {
            if(delta >= 2) {
                return 0;
            } else {
                return 2 - delta;
            }
        } else {
            if(delta >= 1) {
                return k - winner;
            } else {
                int t = k - winner;
                if(t < 2) {
                    return t + 1;
                } else {
                    return t;
                }
            }
        }
    }
}
