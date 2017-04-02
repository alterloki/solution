/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 01.01.15
 * Time: 23:10
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class HalloweenParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int k = scanner.nextInt();
            System.out.println(solve(k));
        }
    }

    private static long solve(long k) {
        if (k % 2 == 0) {
            return k / 2 * k / 2;
        } else {
            return (long) Math.floor((double) k / 2) * (long) Math.ceil((double) k / 2);
        }
    }
}
