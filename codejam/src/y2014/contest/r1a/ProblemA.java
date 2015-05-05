package y2014.contest.r1a;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
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
            int l = scanner.nextInt();
            int[][] outlets = new int[n][l];
            for(int j = 0; j < n; j++) {
                String outlet = scanner.next();
                for (int k = 0; k < outlet.toCharArray().length; k++) {
                    outlets[j][k] = (int) (outlet.toCharArray()[k] - '0');
                }
            }
            int[][] devices = new int[n][l];
            for(int j = 0; j < n; j++) {
                String device = scanner.next();
                for (int k = 0; k < device.toCharArray().length; k++) {
                    devices[j][k] = (int) (device.toCharArray()[k] - '0');

                }
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(n, l, outlets, devices));
            out.newLine();
        }
    }

    private String solveCase(int n, int l, int[][] outlets, int[][] devices) {
        int[][] patterns = new int[n][l];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < outlets.length; i++) {
            int[] outlet = outlets[i];
            int[] device = devices[0];
            for (int j = 0; j < outlet.length; j++) {
                if(outlet[j] != device[j]) {
                    patterns[i][j] = 1;
                }
            }
            if(isGood(patterns[i], outlets, devices)) {
                int sum = patternSum(patterns[i]);
                if(sum < minSum) {
                    minSum = sum;
                }
            }
        }
        if(minSum == Integer.MAX_VALUE) {
            return "NOT POSSIBLE";
        }
        return Integer.toString(minSum);
    }

    private int patternSum(int[] pattern) {
        int result = 0;
        for (int aPattern : pattern) {
            result += aPattern;
        }
        return result;
    }

    private class Flow {
        private int[] b;

        public Flow(int[] b) {
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Flow flow = (Flow) o;

            return Arrays.equals(b, flow.b);

        }

        @Override
        public int hashCode() {
            return b != null ? Arrays.hashCode(b) : 0;
        }
    }

    private boolean isGood(int[] pattern, int[][] outlets, int[][] devices) {
        HashSet<Flow> newOutlets = new HashSet<>();
        for (int i = 0; i < outlets.length; i++) {
            int[] outlet = outlets[i];
            int[] newOutlet = new int[outlet.length];
            for (int j = 0; j < pattern.length; j++) {
                newOutlet[j] = (outlet[j] + pattern[j]) % 2;
            }
            newOutlets.add(new Flow(newOutlet));
        }
        for (int i = 0; i < devices.length; i++) {
            int[] device = devices[i];
            if(!newOutlets.contains(new Flow(device))) {
                return false;
            }
        }
        return true;
    }
}
