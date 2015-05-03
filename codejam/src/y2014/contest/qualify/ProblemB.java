/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 12.04.14
 * Time: 12:07
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.io.*;
import java.util.*;

/**
 * tN = время получения новой фермы
 * tN = C / (2 + N*F)
 * TN = время чтобы с текущей  скоростью набрать печеньев
 * TN = X / (2 + N*F)
 * t0 = прошедшее время
 * Если tN + T(N+1) > TN, то не получаем новую ферму
 *
 * TESTED
 * @author ashevenkov
 */
public class ProblemB {

    public static final String TITLE = "B-large-practice";
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
        new ProblemB().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            double c = Double.parseDouble(scanner.next());
            double f = Double.parseDouble(scanner.next());
            double x = Double.parseDouble(scanner.next());
            out.write("Case #" + (i + 1) + ": " + solveCase(c, f, x));
            out.newLine();
        }
    }

    private String solveCase(double c, double f, double x) {
        double t0 = 0;
        boolean finished = false;
        int n = 0;
        while(!finished) {
            double tN = c / (2 + n * f);
            double TN = x / (2 + n * f);
            double TN1 = x / (2 + (n+1) * f);
            if(tN + TN1 >= TN) {
                t0 += TN;
                finished = true;
            } else {
                t0 += tN;
                n++;
            }
        }
        return Double.toString(t0);
    }
}
