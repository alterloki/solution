/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 05.04.15
 * Time: 23:44
 */
package y2013.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemB {

    public static final String TITLE = "B-large-practice";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = prodOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("codejam/output/" + TITLE + ".out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("codejam/input/" + TITLE + ".in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static BufferedWriter testOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader testIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new ProblemB().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] heights = new int[n][m];
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < m; c++) {
                    heights[r][c] = scanner.nextInt();
                }
            }
            out.write("Case #" + (i + 1) + ": " + solveHeights(heights));
            out.newLine();
        }
    }

    private String solveHeights(int[][] heights) {
        int[] maxRow = new int[heights.length];
        int[] maxCol = new int[heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                int h = heights[i][j];
                if(h > maxRow[i]) {
                    maxRow[i] = h;
                }
                if(h > maxCol[j]) {
                    maxCol[j] = h;
                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                int h = heights[i][j];
                if(h < maxRow[i] && h < maxCol[j]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
