package train.r1;

import java.io.*;
import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov 05.05.16 10:49.
 */
public class ProblemA {

    public static final String TITLE = "A-large";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

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
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        System.out.println(solveCase(n, m, a));
    }

    private long solveCase(int n, int m, int a) {
        long na = 0;
        if(n % a == 0) {
            na = n / a;
        } else {
            na = n / a + 1;
        }
        long ma = 0;
        if(m % a == 0) {
            ma = m / a;
        } else {
            ma = m / a + 1;
        }
        return na*ma;
    }
}
