/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.01.15
 * Time: 3:09
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            long l = scanner.nextLong();
            System.out.println(solve(l));
        }
    }

    private static long solve(long l) {
        return ~l - 0xFFFFFFFF00000000L;
    }
}
