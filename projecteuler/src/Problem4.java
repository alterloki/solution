/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 17:00
 */

import ru.alterloki.Util;

/**
 * Largest palindrome product
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * @author ashevenkov
 */
public class Problem4 {

    public static void main(String[] args) {
        int result = 0;
        for(int i = 100; i < 1000; i++) {
            for(int j = i; j < 1000; j++) {
                int mul = i * j;
                if(isPalindrome(mul) && mul > result) {
                    result = mul;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isPalindrome(int mul) {
        return mul == Util.revertNumber(mul);
    }
}
