/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 22:44
 */

import ru.alterloki.Util;

/**
 * Multiples of 3 and 5
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author ashevenkov
 */
public class Problem1 {

    public static void main(String[] args) {
        int result = 0;
        for(int i = 1; i < 1000; i++) {
            if(Util.isMultiple(i, 3) || Util.isMultiple(i, 5))  {
                result+=i;
            }
        }
        System.out.println(result);
    }
}
