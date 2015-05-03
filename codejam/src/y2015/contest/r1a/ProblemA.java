package y2015.contest.r1a;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemA {

    public static final String TITLE = "A-large-practice";
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
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] m = new int[n];
            for(int j = 0; j < n; j++) {
                m[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveEach(m));
            out.newLine();
        }

    }

    private String solveEach(int[] m) {
        int k1 = 0;
        int prev = m[0];
        int maxDelta = 0;
        for (int i = 1; i < m.length; i++) {
            int mCur = m[i];
            if(mCur < prev) {
                int delta = prev - mCur;
                k1 += delta;
                if(delta > maxDelta) {
                    maxDelta = delta;
                }
            }
            prev = mCur;
        }
        int k2 = 0;
        prev = m[0];
        for (int i = 1; i < m.length; i++) {
            int mCur = m[i];
            if(prev < maxDelta) {
                k2 += prev;
            } else {
                k2 += maxDelta;
            }
            prev = mCur;
        }
        return k1 + " " + k2;
    }

}
