package train.r352;

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
        out.write(solveCase(n));
        out.write("\n");
    }

    private char solveCase(int n) {
        int lastPos = 0;
        int counter = 1;
        while(lastPos <= n - 1) {
            String s = Integer.toString(counter++);
            int start = lastPos;
            lastPos+=s.length();
            if(lastPos > n - 1) {
                return s.charAt(n - 1 - start);
            }
        }
        return '0';
    }
}
