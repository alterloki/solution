/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 11.04.15
 * Time: 11:35
 */
package y2015.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemA {
    public static final String TITLE = "A-large";
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
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int smax = scanner.nextInt();
            int[] s = new int[smax + 1];
            String sString = scanner.next();
            char[] sca = sString.toCharArray();
            for(int j = 0; j <= smax; j++) {
                s[j] = sca[j] - '0';
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(s));
            out.newLine();
        }
    }

    private int solveCase(int[] s) {
        int[] sum = new int[s.length];
        sum[0] = 0;
        for(int i = 1; i < s.length; i++) {
            sum[i] = sum[i - 1] + s[i - 1];
        }
        int result = 0;
        for(int i = 1; i < s.length; i++) {
            sum[i] += result;
            if(sum[i] < i) {
                result += i - sum[i];
            }
        }
        return result;
    }
}
