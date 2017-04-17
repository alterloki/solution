package week31;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ashevenkov 10.04.17 11:02.
 */
public class BeautifulWord {

    private static Set<Character> vowels = new HashSet<>();

    public static void main(String[] args) {
        prepareVowels();
        Scanner in = new Scanner(System.in);
        String w = in.next();
        if(isBeautiful(w)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void prepareVowels() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
    }

    private static boolean isBeautiful(String w) {
        char[] ca = w.toCharArray();
        char prev = ca[0];
        for (int i = 1; i < ca.length; i++) {
            char c = ca[i];
            if(c == prev) {
                return false;
            }
            if (vowels.contains(c) && vowels.contains(prev)) {
                return false;
            }
            prev = c;
        }
        return true;
    }
}
