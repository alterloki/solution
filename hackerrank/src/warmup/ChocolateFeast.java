/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 01.01.15
 * Time: 22:48
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, c, m));
        }
    }

    private static int solve(int n, int c, int m) {
        int result = 0;
        while(n >= c) {
            n -= c;
            result++;
            if(result % m == 0) {
                result++;
            }
        }
        return result;
    }
}
