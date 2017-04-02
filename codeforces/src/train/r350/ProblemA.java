package train.r350;

import java.io.*;
import java.util.Scanner;

/**
 * //TESTED
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
        System.out.println(solveCase(n));
    }

    private String solveCase(int n) {
        int minDays = Integer.MAX_VALUE;
        int maxDays = 0;
        for(int i = 0; i < 7; i++) {
            int weekends = 0;
            for(int j = 0; j < n; j++) {
                int dayOfWeek = (i + j) % 7;
                if(dayOfWeek == 5 || dayOfWeek == 6) {
                    weekends++;
                }
            }
            if(weekends > maxDays) {
                maxDays = weekends;
            }
            if(weekends < minDays) {
                minDays = weekends;
            }
        }
        return minDays + " " + maxDays;
    }
}
