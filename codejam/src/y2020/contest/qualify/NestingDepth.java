package y2020.contest.qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NestingDepth {
    private static BufferedReader in = createIn();
    private static BufferedWriter out = createOut();

    private static BufferedWriter createOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader createIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new NestingDepth().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            String s = scanner.next();
            String result = solveCase(s);
            out.write("Case #" + (i + 1) + ": " + result + "\n");
        }
    }

    private String solveCase(String s) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        int opened = 0;
        for(int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            if(prev <= current) {
                int delta = current - prev;
                for(int j = 0; j < delta; j++) {
                    sb.append('(');
                    opened++;
                }
            } else {
                int delta = prev - current;
                for(int j = 0; j < delta; j++) {
                    sb.append(')');
                    opened--;
                }
            }
            sb.append(s.charAt(i));
            prev = current;
        }
        for(int j = 0; j < opened; j++) {
            sb.append(')');
        }
        return sb.toString();
    }
}
