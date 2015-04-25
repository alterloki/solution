/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 12.04.15
 * Time: 0:37
 */
package y2015.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemC {

    public static final String TITLE = "C-large-practice";
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
        new ProblemC().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int L = scanner.nextInt();
            long X = scanner.nextLong();
            String st = scanner.next();
            //out.write("l = " + L + " x = " + X + " st = " + st);
            //out.newLine();
            out.write("Case #" + (i + 1) + ": " + solve(L, X, st));
            out.newLine();
        }
    }

    private String solve(int l, long x, String st) {
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            s[i] = toNum(st.charAt(i));
        }
        int xproduct = 1;
        for (int value : s) {
            xproduct = mult(xproduct, value);
        }
        int xlProduct = xpow(xproduct, x);
        if (xlProduct == -1) {
            int first = 1;
            for(int i = 0; i < Math.min(4, x) * l - 1; i++) {
                first = mult(first, s[i % l]);
                if(first == 2) {
                    int second = 1;
                    for(int j = i + 1; j < Math.min(8, x) * l; j++) {
                        second = mult(second, s[j % l]);
                        if(second == 3) {
                            return "YES";
                        }
                    }
                }
            }
        }
        return "NO";
    }

    private int xpow(int xproduct, long x) {
        if(x == 1) {
            return xproduct;
        }
        int q = xpow(xproduct, x / 2);
        if (x % 2 == 0) {
            return mult(q, q);
        } else {
            return mult(mult(q, q), xproduct);
        }
    }

    private int toNum(char c) {
        return c - 'i' + 2;
    }

    private int[][] m = new int[][]{{}, {0, 1, 2, 3, 4}, {0, 2, -1, 4, -3}, {0, 3, -4, -1, 2}, {0, 4, 3, -2, -1}};

    private int mult(int c, int c1) {
        int s;
        if (c > 0 && c1 > 0 || c < 0 && c1 < 0) {
            s = 1;
        } else {
            s = -1;
        }
        return m[Math.abs(c)][Math.abs(c1)] * s;
    }
}
