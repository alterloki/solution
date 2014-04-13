/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 12.04.14
 * Time: 12:07
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * tN = время получения новой фермы
 * tN = C / (2 + N*F)
 * TN = время чтобы с текущей  скоростью набрать печеньев
 * TN = X / (2 + N*F)
 * t0 = прошедшее время
 * Если tN + T(N+1) > TN, то не получаем новую ферму
 *
 * @author ashevenkov
 */
public class ProblemB {
    static String INPUT =
            "4\n" +
                    "30.0 1.0 2.0\n" +
                    "30.0 2.0 100.0\n" +
                    "30.50000 3.14159 1999.19990\n" +
                    "500.0 4.0 2000.0";

    public static void main(String[] args) {
        //new ProblemB().run(INPUT);
        new ProblemB().run(ParseUtil.parseFile("B-large.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            double c = Double.parseDouble(parts[0]);
            double f = Double.parseDouble(parts[1]);
            double x = Double.parseDouble(parts[2]);
            System.out.println("Case #" + (i + 1) + ": " + solve(c, f, x));
        }
    }

    private String solve(double c, double f, double x) {
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
