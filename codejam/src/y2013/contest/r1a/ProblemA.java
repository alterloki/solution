/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.04.14
 * Time: 0:33
 */
package y2013.contest.r1a;

import common.ParseUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ashevenkov
 */
public class ProblemA {

    static String INPUT =
            "5\n" +
                    "1 9\n" +
                    "1 10\n" +
                    "3 40\n" +
                    "1 1000000000000000000\n" +
                    "10000000000000000 1000000000000000000\n";

    public static void main(String[] args) {
        //new ProblemA().run(INPUT);
        new ProblemA().run(ParseUtil.parseFile("A-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            long r = Long.parseLong(parts[0]);
            long t = Long.parseLong(parts[1]);
            System.out.println("Case #" + (i + 1) + ": " + solve(r, t));
        }
    }

    private String solve(long r, long t) {
        BigDecimal br = BigDecimal.valueOf(r);
        BigDecimal bt = BigDecimal.valueOf(t);
        BigDecimal br2 = br.multiply(br);
        BigDecimal c2 = BigDecimal.valueOf(2);
        BigDecimal c4 = BigDecimal.valueOf(4);
        BigDecimal c8 = BigDecimal.valueOf(8);
        BigDecimal c1 = BigDecimal.valueOf(1);
        BigDecimal bs1 = br2.multiply(c4).subtract(c4.multiply(br)).add(c1).add(c8.multiply(bt));
        BigDecimal result = sqrtNewtonRaphson(bs1, c1, c1.divide(SQRT_PRE)).add(c1).subtract(c2.multiply(br)).divide(c4);
        int count = (int) Math.floor(result.longValue());
        return Integer.toString(count);
    }

    private static final BigDecimal SQRT_DIG = new BigDecimal(150);
    private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());


    private static BigDecimal sqrtNewtonRaphson(BigDecimal c, BigDecimal xn, BigDecimal precision) {
        BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xn1 = fx.divide(fpx, 2 * SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
        xn1 = xn.add(xn1.negate());
        BigDecimal currentSquare = xn1.pow(2);
        BigDecimal currentPrecision = currentSquare.subtract(c);
        currentPrecision = currentPrecision.abs();
        if (currentPrecision.compareTo(precision) <= -1) {
            return xn1;
        }
        return sqrtNewtonRaphson(c, xn1, precision);
    }
}
