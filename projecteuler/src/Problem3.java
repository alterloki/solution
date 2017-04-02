/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 22:56
 */

import ru.alterloki.Util;

/**
 * Largest prime factor
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p/>
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author ashevenkov
 */
public class Problem3 {
    public static void main(String[] args) {
        long n = 600851475143L;
        long result = 0;
        while(n > 1) {
            long f = Util.smallestFactor(n);
            result = f;
            n /= f;
        }
        System.out.println(result);
    }
}
