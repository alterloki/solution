/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 23.02.14
 * Time: 0:18
 */
package y2008.contest.r1a;

import common.ParseUtil;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p0
 *
 * @author ashevenkov
 */
public class ProblemA {

    static String INPUT =
            "2\n" +
            "3\n" +
            "1 3 -5\n" +
            "-2 4 1\n" +
            "5\n" +
            "1 2 3 4 5\n" +
            "1 0 1 0 1";

    public static void main(String[] args) {
        //new ProblemA().run(INPUT);
        new ProblemA().run(ParseUtil.parseFile("A-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            String vector1 = lines[ln++];
            String vector2 = lines[ln++];
            System.out.println("Case #" + (i + 1) + ": " + solve(toVector(vector1), toVector(vector2)));
        }
    }

    private String solve(long[] v1, long[] v2) {
        Arrays.sort(v1);
        Arrays.sort(v2);
        long result = 0;
        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[v1.length - i - 1];
        }
        return Long.toString(result);
    }

    private long[] toVector(String vector) {
        String[] parts = vector.split(" ");
        long[] result = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Long.parseLong(parts[i]);
        }
        return result;
    }

}
