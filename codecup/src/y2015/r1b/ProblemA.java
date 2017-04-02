package y2015.r1b;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(a, b, k));
        }
    }

    private static int solve(int a, int b, int k) {
        if(a == b) {
            if(k == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        int nMax = Math.max(a, b);
        int nMin = Math.min(a, b);
        int result = 0;
        if(nMin > 99) {
            if(k == 1) {
                return 0;
            } else {
                int delta = nMin - 99;
                nMax -= delta;
                nMin -= delta;
                result += delta;
            }
        }
        int count = 0;
        for(int i = nMin; i > 0; i--) {
            int curMax = nMax - count;
            if(curMax > 99) {
                curMax = 99;
            }
            if(i * k == curMax) {
                return result + count;
            }
            count++;
        }
        return -1;
    }
}
