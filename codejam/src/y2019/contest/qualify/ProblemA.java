package y2019.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemA {

    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

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
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            String d = scanner.next();
            String[] result = solveCase(d);
            out.write("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + "\n");
        }
    }

    private String[] solveCase(String input) {
        String[] result = new String[2];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] ca = input.toCharArray();
        for (char c : ca) {
            if (c == '4') {
                sb1.append('2');
                sb2.append('2');
            } else {
                sb1.append(c);
                sb2.append('0');
            }
        }
        result[0] = sb1.toString();
        result[1] = trim(sb2.toString());
        return result;
    }

    private String trim(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                return s.substring(i);
            }
        }
        return s;
    }

}
