package warmup; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 24.12.14
 * Time: 1:45
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class IsFibo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String result = solve(scanner.nextLong());
            System.out.println(result);
        }
    }

    private static String solve(long num) {
        BigInteger n = BigInteger.valueOf(num);
        BigInteger five = BigInteger.valueOf(5L);
        BigInteger four = BigInteger.valueOf(4L);
        BigInteger checkPlus = n.multiply(n).multiply(five).add(four);
        BigInteger checkMinus = n.multiply(n).multiply(five).subtract(four);
        if (isSqrt(checkPlus) || isSqrt(checkMinus)) {
            return "warmup.IsFibo";
        }
        return "IsNotFibo";
    }

    private static boolean isSqrt(BigInteger checkPlus) {
        BigInteger sqrt = sqrt(checkPlus);
        return sqrt.multiply(sqrt).equals(checkPlus);
    }

    private static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }

}
