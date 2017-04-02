package train.r352;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 05.05.16 19:14.
 */
public class ProblemB {

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
        new ProblemB().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        if(n > 26) {
            out.write("-1");
        } else {
            String str = scanner.next();
            out.write(solveCase(n, str));
        }
        out.write("\n");
    }

    private String solveCase(int n, String str) {
        int[] charCount = new int[26];
        for(int i = 0; i < n; i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        int uniq = 0;
        for(int i = 0; i < 26; i++) {
            if(charCount[i] > 0) {
                uniq++;
            }
        }
        return Integer.toString(str.length() - uniq);
    }
}
