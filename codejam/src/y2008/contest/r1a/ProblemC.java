/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 26.02.14
 * Time: 20:04
 */
package y2008.contest.r1a;

import common.ParseUtil;
import ru.alterloki.Util;

/**
 * @author ashevenkov
 */
public class ProblemC {

    static String INPUT =
            "2\n" +
                    "5\n" +
                    "2";


    /**
     * @param args
     */
    public static void main(String[] args) {
        //new ProblemC().run(INPUT);
        new ProblemC().run(ParseUtil.parseFile("C-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int c = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < c; i++) {
            int n = Integer.parseInt(lines[ln++]);
            System.out.println("Case #" + (i + 1) + ": " + solve(n));
        }
    }

    /**
     * A_n = A^n * (3 5 / 1 3)
     *
     * @param n
     * @return
     */
    private String solve(int n) {
        int[][] A0 = new int[][]{{3, 5}, {1, 3}};
        int[][] An = matrix22Pow(A0, n);
        String s = Integer.toString((2 * An[0][0] - 1) % 1000);
        return s.length() == 1 ? "00" + s : (s.length() == 2 ? "0" + s : s);
    }

    private int[][] matrix22Pow(int[][] m, int n) {
        if (n == 1) {
            return m.clone();
        }
        int[][] result;
        if (n % 2 == 0) {
            int[][] m2 = matrix22Pow(m, n / 2);
            result = matrix22Mult(m2, m2);
        } else {
            result = matrix22Mult(m, matrix22Pow(m, n - 1));
        }
        return result;
    }

    private int[][] matrix22Mult(int[][] a1, int[][] a2) {
            return new int[][]
                    {{
                            (a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0]) % 1000,
                            (a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1]) % 1000},
                    {
                            (a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0]) % 1000,
                            (a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1]) % 1000}};
    }
}
