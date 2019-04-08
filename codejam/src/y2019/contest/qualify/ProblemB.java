package y2019.contest.qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemB {

    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

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
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            String p = scanner.next();
            String result = solveCase(n, p);
            out.write("Case #" + (i + 1) + ": " + result + "\n");
        }
    }

    private String solveCase(int n, String path) {
        if(path.charAt(0) == 'S' && path.charAt(path.length() - 1) == 'E') {
            return constructDoublePath('E', n - 1, 'S', n - 1);
        } else if(path.charAt(0) == 'E' && path.charAt(path.length() - 1) == 'S'){
            return constructDoublePath('S', n - 1, 'E', n - 1);
        } else if(path.charAt(0) == 'E' && path.charAt(path.length() - 1) == 'E') {
            int firstDouble = searchFirstDouble(path, 'S');
            return constructTriplePath('S', firstDouble, 'E', n - 1, 'S', n - firstDouble - 1);
        } else {
            int firstDouble = searchFirstDouble(path, 'E');
            return constructTriplePath('E', firstDouble, 'S', n - 1, 'E', n - firstDouble - 1);
        }
    }

    private String constructTriplePath(char c1, int n1, char c2, int n2, char c3, int n3) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n1; i++) {
            result.append(c1);
        }
        for(int i = 0; i < n2; i++) {
            result.append(c2);
        }
        for(int i = 0; i < n3; i++) {
            result.append(c3);
        }
        return result.toString();
    }

    private int searchFirstDouble(String path, char c) {
        int charCount = 0;
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == c) {
                if(i > 0 && path.charAt(i - 1) == path.charAt(i)) {
                    return charCount;
                }
                charCount++;
            }
        }
        return -1;
    }

    private String constructDoublePath(char c1, int n1, char c2, int n2) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n1; i++) {
            result.append(c1);
        }
        for(int i = 0; i < n2; i++) {
            result.append(c2);
        }
        return result.toString();
    }

}
