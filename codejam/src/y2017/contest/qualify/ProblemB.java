package y2017.contest.qualify;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemB {

    public static final String TITLE = "B-large";
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
        for(int i = 0; i < t; i++) {
            String number = scanner.next();
            out.write("Case #" + (i + 1) + ": " + solveCase(number));
            out.newLine();
        }
    }

    private String solveCase(String number) {
        char[] ca = number.toCharArray();
        for(int i = number.length() - 2; i >= 0; i--) {
            if(ca[i] > ca[i + 1]) {
                substract(ca, i);
            }
        }
        return new BigInteger(new String(ca)).toString();
    }

    private void substract(char[] ca, int i) {
        ca[i] -= 1;
        for(int j = i + 1; j < ca.length; j++) {
            ca[j] = '9';
        }
    }

    private boolean isTidy(BigInteger bi) {
        char[] ca = bi.toString().toCharArray();
        char prev = '0';
        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if(c < prev) {
                return false;
            }
            prev = c;
        }
        return true;
    }

}