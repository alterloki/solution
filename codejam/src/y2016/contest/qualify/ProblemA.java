package y2016.contest.qualify;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TESTED
 * @author ashevenkov 09.04.16 10:48.
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
            int n = scanner.nextInt();
            out.write("Case #" + (i + 1) + ": " + solveCase(n));
            out.newLine();
        }
    }

    private String solveCase(int n) {
        if(n == 0) {
            return "INSOMNIA";
        }
        Set<Integer> set = new HashSet<>();
        int prev = n;
        int current = n;
        while(set.size() < 10) {
            addNumbers(current, set);
            prev = current;
            current += n;
        }
        return Integer.toString(prev);
    }

    private void addNumbers(int n, Set<Integer> set) {
        while(n > 0) {
            set.add(n % 10);
            n /= 10;
        }
    }
}
