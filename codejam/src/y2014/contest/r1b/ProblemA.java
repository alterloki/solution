package y2014.contest.r1b;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov on 06.05.15.
 */
public class ProblemA {

    public static final String TITLE = "A-large-practice";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

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
            String[] strs = new String[n];
            for(int j = 0; j < n; j++) {
                strs[j] = scanner.next();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(strs));
            out.newLine();
        }
    }

    private String solveCase(String[] strs) {
        int result = 0;
        int[] pointers = new int[strs.length];
        while (pointers[0] < strs[0].length()) {
            int[] currentCount = new int[strs.length];
            char c = strs[0].charAt(pointers[0]);
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if(pointers[i] < str.length() && str.charAt(pointers[i]) == c) {
                    while(pointers[i] < str.length() && str.charAt(pointers[i]) == c) {
                        currentCount[i]++;
                        pointers[i]++;
                    }
                } else {
                    return "Fegla Won";
                }
            }
            result += getMinDelta(currentCount);
        }
        return Integer.toString(result);
    }

    private int getMinDelta(int[] currentCount) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < currentCount.length; i++) {
            int curSum = 0;
            for (int j = 0; j < currentCount.length; j++) {
                if(i != j) {
                    curSum += Math.abs(currentCount[j] - currentCount[i]);
                }
            }
            result = Math.min(result, curSum);
        }
        return result;
    }
}
