/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 22.02.14
 * Time: 22:05
 */
package y2010.africa.qualify;

import common.ParseUtil;

/**
 * @author ashevenkov
 */
public class ProblemB {

    private static String INPUT =
            "3\n" +
                    "this is a test\n" +
                    "foobar\n" +
                    "all your base";

    public static void main(String[] args) {
        //new ProblemB().run(INPUT);
        new ProblemB().run(ParseUtil.parseFile("B-large-practice.in"));
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
        String[] words = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
