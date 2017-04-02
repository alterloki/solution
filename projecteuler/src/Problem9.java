/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 22:39
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Special Pythagorean triplet
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * @author ashevenkov
 */
public class Problem9 {
    public static void main(String[] args) {
        for(int b = 1; b < 1000; b++) {
            for(int a = 1; a < b; a++) {
                int c = 1000 - a - b;
                if(c * c == a * a + b * b) {
                    System.out.println(a * b * c);
                    return;
                }
            }
        }
    }
}
