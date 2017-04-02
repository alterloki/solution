package y2016.contest.r1c;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * //TESTED
 * @author ashevenkov 30.04.16 18:49.
 */
public class ProblemB {

    public static final String TITLE = "B-small-attempt0";
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
        new ProblemB().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int b = scanner.nextInt();
            long m = scanner.nextLong();
            out.write("b = " + b + " m = " + m + "\n");
            out.write("Case #" + (i + 1) + ": " + solveCase(b, m));
            out.newLine();
        }
    }

    private String solveCase(int b, long m) {
        long maxCheck = (long) Math.pow(2, b - 2);
        if(m <= maxCheck) {
            int[][] result = new int[b][];
            for (int i = 0; i < result.length; i++) {
                result[i] = new int[b];
                for(int j = i + 1; j < b - 1; j++) {
                    result[i][j] = 1;
                }
            }
            if(m == maxCheck) {
                for(int i = 0; i < b - 1; i++) {
                    result[i][b - 1] = 1;
                }
            } else {
                int counter = 1;
                while(m > 0) {
                    if(m % 2 == 1) {
                        result[counter][b - 1] = 1;
                    }
                    counter++;
                    m = m >> 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("POSSIBLE\n");
            for (int i = 0; i < result.length; i++) {
                int[] ints = result[i];
                if(i > 0) {
                    sb.append("\n");
                }
                for (int j = 0; j < ints.length; j++) {
                    int anInt = ints[j];
                    if(j > 0) {
                        sb.append(" ");
                    }
                    sb.append(anInt);
                }
            }
            return sb.toString();
        }
        return "IMPOSSIBLE";
    }


}
