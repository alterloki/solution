/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 06.04.15
 * Time: 1:36
 */
package y2013.contest.qualify;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * //TESTED
 * @author ashevenkov
 */
public class ProblemC {
    public static final String TITLE = "C-large-practice-2";
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

    final static BigInteger TWO = new BigInteger("2");

    public static BigInteger sqrt(BigInteger N) {
        BigInteger result = N.divide(TWO);
        while (result.multiply(result).subtract(N).compareTo(BigInteger.ONE.divide(new BigInteger("100000000"))) > 0)
            result = result.add(N.divide(result)).divide(TWO);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new ProblemC().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        Set<BigInteger> fairAndSquare = findAllFairAndSquare();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            BigInteger a = new BigInteger(scanner.next());
            BigInteger b = new BigInteger(scanner.next());
            int result = 0;
            for (BigInteger f : fairAndSquare) {
                if (f.compareTo(a) >= 0 && f.compareTo(b) <= 0) {
                    result++;
                }
            }
            out.write("Case #" + (i + 1) + ": " + result);
            out.newLine();
        }
    }

    private static class Fair {
        private int sum;
        private String number;

        private Fair(int sum, String number) {
            this.sum = sum;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fair fair = (Fair) o;

            if (number != null ? !number.equals(fair.number) : fair.number != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return number != null ? number.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Fair{" +
                    "number='" + number + '\'' +
                    '}';
        }
    }

    private SortedSet<BigInteger> findAllFairAndSquare() {
        HashSet<Fair> prev = new HashSet<>();
        TreeSet<BigInteger> result = new TreeSet<>();
        result.add(new BigInteger("1"));
        result.add(new BigInteger("4"));
        result.add(new BigInteger("9"));
        prev.add(new Fair(1, "1"));
        prev.add(new Fair(4, "2"));
        prev.add(new Fair(9, "3"));
        for (int i = 1; i <= 25; i++) {
            addLevel(prev, result);
        }
        return result;
    }
    //110100100000000000000000000000000000000001001011

    private void addLevel(HashSet<Fair> prev, Set<BigInteger> result) {
        HashSet<Fair> next = new HashSet<>();
        for (Fair fair : prev) {
            addToResult(result, fair);
            for (int i = 0; i < 4; i++) {
                if (fair.sum + i * i <= 9) {
                    next.add(new Fair(fair.sum + i * i, fair.number + i));
                }
            }
        }
        prev.clear();
        prev.addAll(next);
    }

    private void addToResult(Set<BigInteger> result, Fair fair) {
        if (fair.sum * 2 <= 9) {
            String reversed = new StringBuilder(fair.number).reverse().toString();
            BigInteger bi0 = new BigInteger(fair.number + reversed);
            result.add(bi0.multiply(bi0));
            for (int i = 0; i < 4; i++) {
                if (fair.sum + i * i + fair.sum <= 9) {
                    BigInteger bi1 = new BigInteger(fair.number + i + reversed);
                    result.add(bi1.multiply(bi1));
                }
            }
        }
    }
}
