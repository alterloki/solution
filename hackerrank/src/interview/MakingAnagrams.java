package interview;

import java.util.Map;
import java.util.Scanner;

/**
 * @author ashevenkov 10.04.17 12:15.
 */
public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        int[] firstAlphabet = fromString(first);
        int[] secondAlphabet = fromString(second);
        int result = 0;
        for (int i = 0; i < firstAlphabet.length; i++) {
            result += Math.abs(firstAlphabet[i] - secondAlphabet[i]);
        }
        return result;
    }

    private static int[] fromString(String s) {
        int[] result = new int['z' - 'a' + 1];
        char[] ca = s.toCharArray();
        for (char c : ca) {
            result[c - 'a']++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
