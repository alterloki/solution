/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 16.01.15
 * Time: 2:17
 */
package search;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CircleCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(r, k));
        }
    }

    private static String solve(int r, int k) {
        double radius = Math.sqrt(r);
        int count = 0;
        for (int a = 1; a < radius; a++) {
            int bs = r - a * a;
            int pb = (int) Math.sqrt(bs);
            if (pb * pb == bs) {
                count++;
            }
        }
        count *= 4;
        int intRad = (int) radius;
        if (r == intRad * intRad) {
            count += 4;
        }
        if (k >= count) {
            return "possible";
        } else {
            return "impossible";
        }
    }
}
