/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 22:50
 */

import ru.alterloki.Util;

/**
 * Summation of primes
 * Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 * @author ashevenkov
 */
public class Problem10 {

    public static void main(String[] args) {
        int[] primes = Util.generatePrimes(2000000);
        long sum = 0;
        for (int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            sum += prime;
        }
        System.out.println(sum);
    }
}
