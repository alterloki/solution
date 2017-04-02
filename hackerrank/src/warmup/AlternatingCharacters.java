/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.12.14
 * Time: 2:26
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class AlternatingCharacters {

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
        char[] ca = s.toCharArray();
        char prev = 0;
        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if(c == prev) {
                result++;
            }
            prev = c;
        }
        return result;
    }
}
