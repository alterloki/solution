/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 18.04.14
 * Time: 11:53
 */
package y2008.contest.r1b;

import common.ParseUtil;

/**
 * @author ashevenkov
 */
public class ProblemB {

    static String INPUT =
            "7\n" +
                    "1 0 0\n" +
                    "1 0 2\n" +
                    "3 0 0\n" +
                    "3 2 0\n" +
                    "3 1 1\n" +
                    "4 1 1\n" +
                    "4 0 2";

    public static void main(String[] args) {
        //new ProblemB().run(INPUT);
        new ProblemB().run(ParseUtil.parseFile("B-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int count = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < count; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            System.out.println("Case #" + (i + 1) + ": " + solve(n, x, y));
        }
    }

    private String solve(int n, int x, int y) {
        //calc local h, local n, local row
        if(x < 0) {
            x = -x;
        }
        if(x%2 != y%2) {
            return "0";
        }
        if(n == 1) {
            if(x == y && x == 0) {
                return "1";
            } else {
                return "0";
            }
        }
        int pyramidIndex = (int)Math.ceil((Math.sqrt(8*n + 1) + 1)/4);
        int realIndex = (x + y)/2 + 1;
        if(realIndex > pyramidIndex) {
            return "0";
        } else if(realIndex < pyramidIndex) {
            return "1";
        } else {
            int inH = 2*pyramidIndex - 1;
            int prevIndex = pyramidIndex - 1;
            int inN = n - 2*prevIndex*prevIndex + prevIndex;
            int inRow = y + 1;
            if(x == 0 && inN < 2*inH - 1) {
                return "0";
            }
            return Double.toString(prob(inH, inN, inRow));
        }
    }

    private double prob(int h, int n, int row) {
        double[][] p = new double[n + 1][];
        p[0] = new double[row + 1];
        for(int i = 0; i <= row; i++) {
            p[0][i] = 0;
        }
        p[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            p[i] = new double[row + 1];
            p[i][0] = 1;
            for(int j = 1; j <= row; j++) {
                if(i < h) {
                    p[i][j] = 0.5*(p[i-1][j] + p[i-1][j-1]);
                } else {
                    if(j <= (i-h+1)) {
                        p[i][j] = 1;
                    } else {
                        p[i][j] = 0.5*(p[i-1][j] + p[i-1][j-1]);
                    }
                }
            }
        }
        return p[n][row];
    }
}
