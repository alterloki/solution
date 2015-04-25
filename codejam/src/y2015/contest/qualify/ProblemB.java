/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 11.04.15
 * Time: 11:52
 */
package y2015.contest.qualify;

import java.io.*;
import java.util.*;

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
        for (int i = 0; i < t; i++) {
            int d = scanner.nextInt();
            int[] p = new int[d];
            for (int j = 0; j < d; j++) {
                p[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(p));
            out.newLine();
        }
    }

    private int solveCase(int[] p) {
        int result = max(p);
        for(int i = 1; i < result; i++) {
            int steps = 0;
            for (int j = 0; j < p.length; j++) {
                int n = p[j];
                if(n > i) {
                    steps += (n - 1) / i;
                }
            }
            steps += i;
            result = Math.min(result, steps);
        }
        return result;
    }

    private int max(int[] p) {
        int max = 0;
        for (int aP : p) {
            if (aP > max) {
                max = aP;
            }

        }
        return max;
    }

    private static class State {
        private ArrayList<Integer> pa;
        private int steps;

        private State(ArrayList<Integer> pa, int steps) {
            this.pa = pa;
            this.steps = steps;
        }
    }
}
