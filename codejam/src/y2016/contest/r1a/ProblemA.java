package y2016.contest.r1a;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov 30.04.16 18:49.
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
            String s = scanner.next();
            out.write("Case #" + (i + 1) + ": " + solveCase(s));
            out.newLine();
        }
    }

    private String solveCase(String s) {
        char[] ca = s.toCharArray();
        smartSort(ca, 0, s.length());
        return new String(ca);
    }

    private void smartSort(char[] ca, int from, int to) {
        if(to - from > 1) {
            int mIndex = 0;
            char max = 0;
            for (int i = from; i < to; i++) {
                if (ca[i] > max) {
                    mIndex = i;
                    max = ca[i];
                }
            }
            int count = moveAllToBeginning(ca, from, to, max);
            smartSort(ca, from + count, mIndex + count);
        }
    }

    private int moveAllToBeginning(char[] ca, int from, int to, char max) {
        int counter = 0;
        for(int i = from; i < to; i++) {
            if(ca[i] == max) {
                counter++;
                System.arraycopy(ca, from, ca, from + 1, i - from);
                ca[from] = max;
            }
        }
        return counter;
    }


}
