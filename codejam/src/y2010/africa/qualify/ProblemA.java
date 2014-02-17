package y2010.africa.qualify;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 16.02.14
 * Time: 12:45
 */

import common.CodeJamProblem;

/**
 * https://code.google.com/codejam/contest/dashboard?c=351101
 *
 * @author ashevenkov
 */
public class ProblemA extends CodeJamProblem {

    public static void main(String[] args) {
        new ProblemA().run("3\n" +
                "100\n" +
                "3\n" +
                "5 75 25\n" +
                "200\n" +
                "7\n" +
                "150 24 79 50 88 345 3\n" +
                "8\n" +
                "8\n" +
                "2 1 9 4 4 56 90 3",
                "Case #1: 2 3\n" +
                        "Case #2: 1 4\n" +
                        "Case #3: 4 5");
    }
}
