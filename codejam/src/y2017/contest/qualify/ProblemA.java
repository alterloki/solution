package y2017.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
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
            String panc = scanner.next();
            int k = scanner.nextInt();
            out.write("Case #" + (i + 1) + ": " + solveCase(convert(panc), k));
            out.newLine();
        }
    }

    private int[] convert(String part) {
        int[] result = new int[part.length()];
        for (int i = 0; i < part.toCharArray().length; i++) {
            char c = part.toCharArray()[i];
            result[i] = c == '+' ? 1 : 0;
        }
        return result;
    }

    private String solveCase(int[] arr, int k) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if(a == 0) {
                try {
                    rotate(arr, i, k);
                    counter++;
                } catch (Exception e) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return Integer.toString(counter);
    }

    private void rotate(int[] arr, int i, int k) {
        for(int j = i; j < i + k; j++) {
            arr[j] = arr[j] == 1 ? 0 : 1;
        }
    }
}
