/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 02.01.15
 * Time: 1:03
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockTheBeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int threeCount = 0;
        while (threeCount <= n) {
            if (threeCount % 5 == 0 && (n - threeCount) % 3 == 0) {
                return construct(threeCount, n - threeCount);
            }
            threeCount += 5;
        }
        return "-1";
    }

    private static String construct(int threeCount, int fiveCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fiveCount; i++) {
            sb.append('5');
        }
        for (int i = 0; i < threeCount; i++) {
            sb.append('3');
        }
        return sb.toString();
    }
}
