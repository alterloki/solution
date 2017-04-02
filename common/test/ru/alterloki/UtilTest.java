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
        int[] check = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
                59, 61, 67, 71, 73, 79, 83, 89, 97};
        Assert.assertTrue(Arrays.equals(primes, check));
    }

    @Test
    public void testRevert() {
        long a = 4578;
        Assert.assertEquals(8754, Util.revertNumber(a));
    }

    @Test
    public void testCharToNumber() {
        Assert.assertEquals(Util.charToNumber('7'), 7);
    }

    @Test
    public void divisorCount() {
        int[] primes = Util.generatePrimes(500);
        Assert.assertEquals(Util.divisorCount(28, primes), 6);
    }

    @Test
    public void testMatrix22Mult() {
        int[][] m1 = new int[][]{{3, 4}, {5, 6}};
        int[][] m2 = new int[][]{{4, 5}, {6, 7}};
        int[][] eresult = new int[][]{{36, 43}, {56, 67}};
        int[][] mresult = Util.matrix22Mult(m1, m2);
        Assert.assertEquals(mresult[0][0], eresult[0][0]);
        Assert.assertEquals(mresult[0][1], eresult[0][1]);
        Assert.assertEquals(mresult[1][0], eresult[1][0]);
        Assert.assertEquals(mresult[1][1], eresult[1][1]);
    }

    @Test
    public void testMatrix2Pow() {
        int[][] m = new int[][]{{3, 5}, {1, 3}};
        int[][] eresult = new int[][]{{7745024, 17318400}, {3463680, 7745024}};
        int[][] mresult = Util.matrix22Pow(m, 10);
        Assert.assertEquals(mresult[0][0], eresult[0][0]);
        Assert.assertEquals(mresult[0][1], eresult[0][1]);
        Assert.assertEquals(mresult[1][0], eresult[1][0]);
        Assert.assertEquals(mresult[1][1], eresult[1][1]);
    }
}
