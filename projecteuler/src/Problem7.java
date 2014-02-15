/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 19:59
 */

import ru.alterloki.Util;

/**
 * 10001st prime
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 * @author ashevenkov
 */
public class Problem7 {
    public static void main(String[] args) {
        int[] primes = Util.generatePrimes(200000);
        System.out.println(primes[10000]);
    }
}
