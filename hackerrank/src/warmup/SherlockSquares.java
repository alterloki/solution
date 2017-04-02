/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 01.01.15
 * Time: 22:57
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int a, int b) {
        double as = Math.sqrt(a);
        double bs = Math.sqrt(b);
        return (int)(Math.floor(bs) - Math.ceil(as) + 1);
    }
}
