/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 19:03
 */

import ru.alterloki.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Smallest multiple
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author ashevenkov
 */
public class Problem5 {

    public static void main(String[] args) {
        int[] primes = Util.generatePrimes(20);
        Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
        for(int i = 2; i <= 20; i++) {
            int in = i;
            for (int prime : primes) {
                if(prime <= in) {
                    int num = 0;
                    while(in % prime == 0) {
                        in = in / prime;
                        num++;
                    }
                    Integer maxCount = map.get(prime);
                    if(maxCount == null) {
                        maxCount = 0;
                    }
                    if(num > maxCount) {
                        map.put(prime, num);
                    }
                }
            }
        }
        long result = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                result *= entry.getKey();
            }
        }
        System.out.println(result);
    }

    /*
       2 * 3 * 4 * 5 * 7 * 3 * 11 * 13 * 2 * 17 * 19

       1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
     */
    public static void main1(String[] args) {
        long a = 2 * 3 * 4 * 5 * 7 * 3 * 11 * 13 * 2 * 17 * 19;
        System.out.println(a);
    }
}
