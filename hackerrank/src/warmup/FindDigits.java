package warmup; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 22.12.14
 * Time: 0:26
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author ashevenkov
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int result = solve(scanner.nextLong());
            System.out.println(result);
        }
    }

    private static int solve(long num) {
        int result = 0;
        long tnum = num;
        while(tnum > 0) {
            int n = (int) (tnum % 10);
            if(n > 0 && num % n == 0) {
                result++;
            }
            tnum /= 10;
        }
        return result;
    }
}
