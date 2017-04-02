/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.01.15
 * Time: 3:07
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SolveSecond {

    static int solveMeSecond(int a, int b) {
        return a + b;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        int sum;
        int _a, _b;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            _a = in.nextInt();
            _b = in.nextInt();
            sum = solveMeSecond(_a, _b);
            System.out.println(sum);
        }
    }
}
