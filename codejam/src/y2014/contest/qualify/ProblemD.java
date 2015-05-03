/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 13.04.14
 * Time: 0:21
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TEST
 * @author ashevenkov
 */
public class ProblemD {

    public static final String TITLE = "D-large-practice";
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
        new ProblemD().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int count = scanner.nextInt();
            double[] naomi = new double[count];
            for (int j = 0; j < count; j++) {
                naomi[j] = Double.parseDouble(scanner.next());
            }
            double[] ken = new double[count];
            for (int j = 0; j < count; j++) {
                ken[j] = Double.parseDouble(scanner.next());
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(count, naomi, ken));
            out.newLine();
        }
    }

    private String solveCase(int count, double[] naomi, double[] ken) {
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
