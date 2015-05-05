package y2014.contest.r1a;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov on 05.05.15.
 */
public class ProblemC {

    public static final String TITLE = "C-small-practice";
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
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] perm = new int[n];
            for(int j = 0; j < n; j++) {
                perm[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(perm));
            out.newLine();
        }
    }

    private String solveCase(int[] perm) {
        if(score(perm) < (472 + 500)/2) {
            return "BAD";
        } else {
            return "GOOD";
        }
    }

    private int score(int[] perm) {
        int score = 0;
        for (int i = 0; i < perm.length; i++) {
            if(perm[i] < i + 1) {
                score++;
            }
        }
        return score;
    }
}
