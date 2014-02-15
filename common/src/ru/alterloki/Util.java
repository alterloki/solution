/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 22:46
 */
package ru.alterloki;

import java.util.ArrayList;

/**
 * @author ashevenkov
 */
public class Util {
    /**
     * Is b multiple of a
     *
     * @param a - multiple
     * @param b - number to chek
     * @return is b multiple of a
     */
    public static boolean isMultiple(int a, int b) {
        return a % b == 0;
    }

    public static int[] generatePrimes(int i) {
        ArrayList<Integer> primesList = new ArrayList<Integer>();
        for (int j = 2; j < i; j++) {
            boolean isPrime = true;
            for (Integer prime : primesList) {
                if (j % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primesList.add(j);
            }
        }
        System.out.println("Primes till " + i + " generated.");
        return toIntArray(primesList);
    }

    private static int[] toIntArray(ArrayList<Integer> primesList) {
        int[] result = new int[primesList.size()];
        int i = 0;
        for (Integer prime : primesList) {
            result[i++] = prime;
        }
        return result;
    }

    public static long smallestFactor(long n) {
        for (long i = 2, end = (long)Math.sqrt(n); i <= end; i++) {
            if (n % i == 0)
                return i;
        }
        return n;
    }

    public static long revertNumber(long n) {
        long result = 0;
        while(n > 0) {
            result *= 10;
            result += n % 10;
            n = n / 10;
        }
        return result;
    }

    public static int charToNumber(char c) {
        return c - '0';
    }
}
