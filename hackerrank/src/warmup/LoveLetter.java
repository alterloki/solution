/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.12.14
 * Time: 2:32
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class LoveLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int result = solve(scanner.nextLine());
            System.out.println(result);
        }
    }

    private static int solve(String s) {
        int result = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            result += Math.abs(s.charAt(i) - s.charAt(s.length() - i - 1));
        }
        return result;
    }
}
