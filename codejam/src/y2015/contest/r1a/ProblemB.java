package y2015.contest.r1a;

import java.io.*;
import java.util.Scanner;

/**
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
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int[] m = new int[b];
            for (int j = 0; j < b; j++) {
                m[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(n, m));
            out.newLine();
        }
    }

    private int solveCase(int n, int[] m) {
        long maxBarber = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > maxBarber) {
                maxBarber = m[i];
            }
        }
        long to = n * maxBarber;
        long from = -1;
        while(to > from + 1) {
            long middle = (to + from) / 2;
            long currentClients = servedClients(middle, m);
            if(currentClients >= n) {
                to = middle;
            } else {
                from = middle;
            }
        }
        long prevTimeClients = servedClients(to - 1, m);
        long delta = n - prevTimeClients;
        for (int i = 0; i < m.length; i++) {
            if(to % m[i] == 0) {
                delta--;
            }
            if(delta == 0) {
                return (i + 1);
            }
        }
        return 0;
    }

    private long servedClients(long middle, int[] m) {
        long result = 0;
        for (int i = 0; i < m.length; i++) {
            result += middle / m[i] + 1;
        }
        return result;
    }
}
