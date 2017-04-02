package y2015.contest.r1b;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 *
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
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int n = scanner.nextInt();
            out.write("Case #" + (i + 1) + ": " + solveCase(r, c, n));
            out.newLine();
        }
    }

    private int solveCase(int r, int c, int n) {
        if (n <= (r * c) / 2) {
            return 0;
        }
        if (r > c) {
            int tr = r;
            r = c;
            c = tr;
        }
        int toRemove = r * c - n;
        if (r == 1) {
            return (r * c - 2 * toRemove) - 1;
        }
        if (r % 2 == 1 && c % 2 == 1) {
            int p1 = countCase(toRemove, (r * c + 1) / 2, ((c - 2) * (r - 2) + 1) / 2, 4);
            int p2 = countCase(toRemove, (r * c - 1) / 2, ((c - 2) * (r - 2) - 1) / 2, 0);
            return Math.min(p1, p2);
        }
        return countCase(toRemove, r * c / 2, (r - 2) * (c - 2) / 2, 2);
    }

    private int countCase(int toRemove, int all, int four, int two) {

        int three = all - four - two;
        int max = four * 4 + three * 3 + two * 2;
        if (toRemove > four) {
            toRemove -= four;
            max -= four * 4;
        } else {
            max -= toRemove * 4;
            return max;
        }
        if (toRemove > three) {
            toRemove -= three;
            max -= three * 3;
        } else {
            max -= toRemove * 3;
            return max;
        }
        max -= toRemove * 2;
        return max;
    }
}
