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
            int limit = (int) Math.sqrt(j);
            for (Integer prime : primesList) {
                if (prime > limit + 1) {
                    break;
                }
                if (j % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primesList.add(j);
            }
            if (j % 100000 == 0) {
                System.out.println(j);
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
        for (long i = 2, end = (long) Math.sqrt(n); i <= end; i++) {
            if (n % i == 0)
                return i;
        }
        return n;
    }

    public static long revertNumber(long n) {
        long result = 0;
        while (n > 0) {
            result *= 10;
            result += n % 10;
            n = n / 10;
        }
        return result;
    }

    public static int charToNumber(char c) {
        return c - '0';
    }

    public static int divisorCount(int number, int[] primes) {
        int curPrime = 0;
        int result = 1;
        while (number > 1 && primes[curPrime] <= number) {
            int curCount = 0;
            while (number % primes[curPrime] == 0) {
                number /= primes[curPrime];
                curCount++;
            }
            result *= (curCount + 1);
            curPrime++;
        }
        return result;
    }

    /**
     * Multiple 2 int matrix 2 x 2
     *
     * a1[0][0] a1[0][1]
     * a1[1][0] a1[1][1]
     * <p/>
     * a2[0][0] a2[0][1]
     * a2[1][0] a2[1][1]
     * <p/>
     * a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0], a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1]
     * a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0], a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1]
     *
     * @param a1
     * @param a2
     * @return
     */
    public static int[][] matrix22Mult(int[][] a1, int[][] a2) {
        return new int[][]{{a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0], a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1]},
                {a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0], a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1]}};
    }

    public static int[][] matrix22Pow(int[][] m, int n) {
        if(n == 1) {
            return m.clone();
        }
        int[][] result;
        if(n % 2 == 0) {
            int[][] m2 = matrix22Pow(m, n/2);
            result = matrix22Mult(m2, m2);
        } else {
            result = matrix22Mult(m, matrix22Pow(m, n - 1));
        }
        return result;
    }
}

