/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 29.12.14
 * Time: 1:01
 */
package warmup;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ashevenkov
 */


public class GameOfThronesOne {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        Map<Character, Integer> charsCount = new HashMap<>();
        char[] ca = inputString.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            Integer count = charsCount.get(c);
            if(count == null) {
                count = 0;
            }
            count++;
            charsCount.put(c, count);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> charCount : charsCount.entrySet()) {
            if(charCount.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        String ans = "NO";
        if(oddCount < 2) {
            ans = "YES";
        }
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
}
