package y2016.contest.qualify;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov 09.04.16 12:20.
 */
public class ProblemC {

    public static final String TITLE = "C-large";
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
            int j = scanner.nextInt();
            out.write("Case #" + (i + 1) + ": " + solveCase(n, j));
            out.newLine();
        }
    }

    private String solveCase(int n, int j) {
        StringBuilder sb = new StringBuilder();
        BigInteger current = BigInteger.ZERO;
        int count = 0;
        while(count < j) {
            String[] forCurrent = tryCurrent(current, n);
            if(forCurrent != null) {
                count++;
                sb.append('\n');
                for (int i = 0; i < forCurrent.length; i++) {
                    String s = forCurrent[i];
                    if(i != 0) {
                        sb.append(" ");
                    }
                    sb.append(s);
                }
            }
            current = current.add(BigInteger.ONE);
        }
        return sb.toString();
    }

    private String[] tryCurrent(BigInteger current, int n) {
        String[] result = new String[10];
        BigInteger first = BigInteger.ONE.shiftLeft(n - 1);
        current = current.shiftLeft(1);
        current = current.add(BigInteger.ONE);
        current = current.add(first);
        String s = current.toString(2);
        result[0] = s;
        for(int i = 3; i <= 10; i++) {
            BigInteger radixCurrent = new BigInteger(s, i);
            long divider = searchDivider(radixCurrent);
            if(divider <= 0) {
                return null;
            } else {
                result[i - 1] = Long.toString(divider);
            }
        }
        long divider = searchDivider(current);
        if(divider <= 0) {
            return null;
        } else {
            result[1] = Long.toString(divider);
        }
        return result;
    }

    private long searchDivider(BigInteger radixCurrent) {
        long divider = 2;
        while(divider <= 10000) {
            BigInteger d = BigInteger.valueOf(divider);
            if(radixCurrent.remainder(d).equals(BigInteger.ZERO)) {
                return divider;
            }
            divider++;
        }
        return 0;
    }

}
