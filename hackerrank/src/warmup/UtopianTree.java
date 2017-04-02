package warmup; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 24.12.14
 * Time: 2:07
 */

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long result = solve(scanner.nextInt());
            System.out.println(result);
        }
    }

    private static long solve(int n) {
        long result = 1;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                result *= 2;
            } else {
                result += 1;
            }
        }
        return result;
    }
}
