package y2014.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.04.14
 * Time: 11:37
 */
public class ProblemA {

    public static void main(String[] args) throws IOException {
        new ProblemA().fire(System.in);
    }

    private void fire(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        for (int i = 0; i < count; i++) {
            line = br.readLine();
            //n, m, p, q, t
            String[] parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int p = Integer.parseInt(parts[2]);
            int q = Integer.parseInt(parts[3]);
            int t = Integer.parseInt(parts[4]);
            System.out.println(solve(n, m, p, q, t));
        }
    }

    private String solve(int n, int m, int p, int q, int t) {
        int interactiveProblemCount = t / p;
        int commonProblemCount = t / q;
        int interactiveMen = n / interactiveProblemCount;
        int commonMen = m / interactiveProblemCount;
        int interactiveLeftProblems = n - interactiveMen * interactiveProblemCount;
        int commonLeftProblems = m - commonMen * commonProblemCount;
        int needTime = interactiveLeftProblems * p + commonLeftProblems * q;
        int result = interactiveMen + commonMen;
        if (needTime > 0) {
            if(needTime < t) {
                result++;
            } else {
                result += 2;
            }
        }
        return Integer.toString(result);
    }

}
