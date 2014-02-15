/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 23:25
 */
package ru.alterloki;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author ashevenkov
 */
public class UtilTest {

    @Test
    public void testPrimeGenerator() {
        int[] primes = Util.generatePrimes(100);
        int[] check = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
                59, 61, 67, 71, 73, 79, 83, 89, 97};
        Assert.assertTrue(Arrays.equals(primes, check));
    }

    @Test
    public void testRevert() {
        long a = 4578;
        Assert.assertEquals(8754, Util.revertNumber(a));
    }
}
