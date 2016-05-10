package y2016.r1a;

import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(solve(a, b, c, d));
        }
    }

    private static String solve(int a, int b, int c, int d) {

        if (Math.abs(b - c) > 1) {
            return "impossible";
        }
        if(b == 0 && c == 0 && a > 0 && d > 0) {
            return "impossible";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder zeroSB = fill('0', a);
        StringBuilder oneSB = fill('1', d);
        if(b == 0 && c == 0 && a > 0) {
            return "0" + zeroSB.toString();
        }
        if(b == 0 && c== 0 && d > 0) {
            return "1" + oneSB.toString();
        }
        if(b >= c) {
            if(b > 0) {
                sb.append("0");
            }
            while (b > 0 || c > 0) {
                if (b > 0) {
                    sb.append("1");
                    b--;
                }
                if (c > 0) {
                    sb.append("0");
                    c--;
                }
            }
            String str = sb.toString();
            int zi = str.indexOf("0");
            int oi = str.indexOf("1");
            return str.substring(0, zi) + zeroSB.toString() + str.substring(zi, oi) + oneSB.toString() + str.substring(oi);
        } else {
            if(c > 0) {
                sb.append("1");
                while (b > 0 || c > 0) {
                    if (c > 0) {
                        sb.append("0");
                        c--;
                    }
                    if (b > 0) {
                        sb.append("1");
                        b--;
                    }
                }
            }
            String str = sb.toString();
            int zi = str.indexOf("0");
            int oi = str.indexOf("1");
            return str.substring(0, oi) + oneSB.toString() + str.substring(oi, zi) + zeroSB.toString() + str.substring(zi);
        }
    }

    private static StringBuilder fill(char c, int a) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < a; i++) {
            result.append(c);
        }
        return result;
    }
}
