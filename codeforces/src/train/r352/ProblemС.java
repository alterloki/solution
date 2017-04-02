package train.r352;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 05.05.16 19:14.
 */
public class ProblemС {

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
        new ProblemС().solve(in, out);
        out.flush();
        out.close();
    }

    private class P {
        public int x;
        public int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        P a = new P(scanner.nextInt(), scanner.nextInt());
        P b = new P(scanner.nextInt(), scanner.nextInt());
        P t = new P(scanner.nextInt(), scanner.nextInt());
        int n = scanner.nextInt();
        P[] bottles = new P[n];
        for(int i = 0; i < n; i++) {
            bottles[i] = new P(scanner.nextInt(), scanner.nextInt());
        }
        out.write(solveCase(a, b, t, n, bottles));
        out.write("\n");
    }

    private String solveCase(P a, P b, P t, int n, P[] bottles) {
        double sum = 0;
        int used = -1;
        double maxDelta = 0;
        boolean usedA = false;
        double minI = Double.MAX_VALUE;
        for (int i = 0; i < bottles.length; i++) {
            P bottle = bottles[i];
            double d = dist(bottle, t);
            double ai = dist(bottle, a);
            double bi = dist(bottle, b);
            sum += 2*d;
            if(ai < d && (d - ai) > maxDelta) {
                maxDelta = d - ai;
                used = i;
                usedA = true;
            }
            if(bi < d && (d - bi) > maxDelta) {
                maxDelta = d - bi;
                used = i;
                usedA = false;
            }
            if(minI > ai) {
                minI = ai;
                used = i;
            }
            if(minI > bi) {
                minI = bi;
                used = i;
            }
        }
        if(maxDelta == 0) {
            sum -= dist(bottles[used], t);
            sum += minI;
        } else {
            sum -= dist(bottles[used], t);
            sum += usedA ? dist(bottles[used], a) : dist(bottles[used], b);

            for(int i = 0; i < bottles.length; i++) {
                P bottle = bottles[i];
                double d = dist(bottle, t);
                double ai = dist(bottle, a);
                double bi = dist(bottle, b);
                if(!usedA && ai < d && (d - ai) < maxDelta) {
                    maxDelta = d - ai;
                    used = i;
                    usedA = true;
                }
            }
        }
        return Double.toString(sum);
    }

    private double dist(P a, P b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

}
