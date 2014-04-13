/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 13.04.14
 * Time: 0:21
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.util.Arrays;

/**
 * @author ashevenkov
 */
public class ProblemD {

    static String INPUT =
            "4\n" +
                    "1\n" +
                    "0.5\n" +
                    "0.6\n" +
                    "2\n" +
                    "0.7 0.2\n" +
                    "0.8 0.3\n" +
                    "3\n" +
                    "0.5 0.1 0.9\n" +
                    "0.6 0.4 0.3\n" +
                    "9\n" +
                    "0.186 0.389 0.907 0.832 0.959 0.557 0.300 0.992 0.899\n" +
                    "0.916 0.728 0.271 0.520 0.700 0.521 0.215 0.341 0.458";

    public static void main(String[] args) {
        //new ProblemD().run(INPUT);
        new ProblemD().run(ParseUtil.parseFile("D-large.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            int count = Integer.parseInt(line);
            line = lines[ln++];
            String[] parts = line.split(" ");
            double[] naomi = new double[parts.length];
            for (int j = 0; j < naomi.length; j++) {
                naomi[j] = Double.parseDouble(parts[j]);
            }
            line = lines[ln++];
            parts = line.split(" ");
            double[] ken = new double[parts.length];
            for (int j = 0; j < ken.length; j++) {
                ken[j] = Double.parseDouble(parts[j]);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(count, naomi, ken));

        }
    }

    private String solve(int count, double[] naomi, double[] ken) {
        double[] nc = naomi.clone();
        double[] kc = ken.clone();
        int warResult = warResult(naomi, ken);
        int warResult2 = warResult(kc, nc);
        return Integer.toString(warResult2) + " " + Integer.toString(count - warResult) ;
    }

    private int warResult(double[] naomi, double[] ken) {
        int warResult = 0;
        Arrays.sort(naomi);
        reverse(naomi);
        Arrays.sort(ken);
        reverse(ken);
        int kIndex = 0;
        for (int i = 0; i < naomi.length; i++) {
            double n = naomi[i];
            if (ken[kIndex] > n) {
                kIndex++;
                warResult++;
            }
        }
        return warResult;
    }

    private void reverse(double[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            double temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }
}
