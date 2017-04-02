/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 22.02.14
 * Time: 23:33
 */
package y2010.africa.qualify;

import common.ParseUtil;

import java.util.Map;

/**
 * https://code.google.com/codejam/contest/dashboard?c=351101#s=p2
 *
 * @author ashevenkov
 */
public class ProblemC {

    private static String INPUT =
            "4\n" +
                    "hi\n" +
                    "yes\n" +
                    "foo  bar\n" +
                    "hello world";

    private static Object[] symbArr = new Object[]{
            'a', "2", 'b', "22", 'c', "222", 'd', "3", 'e', "33", 'f', "333", 'g', "4", 'h', "44", 'i', "444",
            'j', "5", 'k', "55", 'l', "555", 'm', "6", 'n', "66", 'o', "666", 'p', "7", 'q', "77", 'r', "777", 's', "7777",
            't', "8", 'u', "88", 'v', "888", 'w', "9", 'x', "99", 'y', "999", 'z', "9999", ' ', "0"};

    private static Map<Character, String> symbMap = new java.util.HashMap<Character, String>();
    private static Map<Character, Character> keyMap = new java.util.HashMap<Character, Character>();

    public static void main(String[] args) {
        fillMaps();
        //new ProblemC().run(INPUT);
        new ProblemC().run(ParseUtil.parseFile("C-large-practice.in"));
    }

    private static void fillMaps() {
        for(int i = 0; i < symbArr.length / 2; i++) {
            char c = (Character)symbArr[2 * i];
            String s = (String)symbArr[2 * i + 1];
            symbMap.put(c, s);
            keyMap.put(c, s.toCharArray()[0]);
        }
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(lines[ln++]));
        }
    }

    private String solve(String line) {
        char[] ca = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prevKey = '-';
        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            String str = symbMap.get(c);
            Character key = keyMap.get(c);
            if(prevKey == key) {
                sb.append(" ");
            }
            sb.append(str);
            prevKey = key;
        }
        return sb.toString();
    }

}
