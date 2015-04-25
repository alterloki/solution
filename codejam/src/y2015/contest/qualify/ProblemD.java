/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 11.04.15
 * Time: 14:13
 */
package y2015.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemD {
    public static final String TITLE = "D-large-practice";
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
        new ProblemD().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            out.write("Case #" + (i + 1) + ": " + solveCase(x, r, c));
            out.newLine();
        }
    }


    private String solveCase(int x, int r, int c) {
        int min = Math.min(r, c);
        int max = Math.max(r, c);
        if (r * c % x > 0) {
            return "RICHARD";
        }
        if(x == 3 && min == 1) {
            return "RICHARD";
        }
        if(x == 4 && min <= 2) {
            return "RICHARD";
        }
        if(x == 5) {
            if(min <= 2 || (min == 3 && max == 5)) {
                return "RICHARD";
            }
        }
        if(x == 6 && min <= 3) {
            return "RICHARD";
        }
        if(x >= 7) {
            return "RICHARD";
        }
        return "GABRIEL";
    }
}
