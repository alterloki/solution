package train.r539;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 05.05.16 19:14.
 */
public class ProblemA {

    public static final String TITLE = "A-large";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("codeforces/output/" + TITLE + ".out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("codeforces/input/" + TITLE + ".in"));
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
        int v = scanner.nextInt();
        int result = doSolve(n, v);
        out.write(Integer.toString(result));
    }

    private int doSolve(int n, int v) {
        if(v >= n - 1) {
            return n - 1;
        } else {
            int result = v;
            for(int i = 2; i <= n - v; i++) {
                result += i;
            }
            return result;
        }
    }

}
