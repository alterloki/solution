package y2015.contest.r1b;

import java.io.*;
import java.util.*;

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
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            out.write("Case #" + (i + 1) + ": " + solveCase(n));
            out.newLine();
        }
    }

    private long solveCase(long k) {
        if (k < 10) {
            return k;
        }
        long result = 10;
        long current = 10;
        while (numberCount(current) < numberCount(k)) {
            current *= 10;
            int numPrev = numberCount(current) - 1;
            result += Math.pow(10, numPrev / 2) - 1;
            result += 1;
            result += Math.pow(10, numPrev - numPrev / 2) - 2;
            result += 1;
        }
        String left = Long.toString(k).substring(0, numberCount(k) / 2);
        String right = Long.toString(k).substring(numberCount(k) / 2);
        if (Long.parseLong(right) == 0) {
            return solveCase(k - 1) + 1;
        }
        if ((left.charAt(0) == '1') && (left.length() == 1 || Long.parseLong(left.substring(1)) == 0)) {
            result += Long.parseLong(right);
        } else {
            StringBuilder leftB = new StringBuilder(left);
            result += Long.parseLong(leftB.reverse().toString());
            result += 1;
            result += (Long.parseLong(right) - 1);
        }
        return result;
    }

    private int numberCount(long result) {
        return (int) (Math.log10(result)) + 1;
    }

    private long reverse(long n) {
        String result = new StringBuilder(Long.toString(n)).reverse().toString();
        return Long.parseLong(result);
    }


}
