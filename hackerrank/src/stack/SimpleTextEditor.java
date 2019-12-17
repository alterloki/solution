package stack;

import java.io.*;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        new SimpleTextEditor().solve(scanner, out);
    }

    private void solve(Scanner scanner, BufferedWriter out) throws IOException {
        int q = scanner.nextInt();
        String s = "";
        for(int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            switch (type) {
                case 1: s = append(s, scanner.next());
                case 2: s = delete(s, scanner.nextInt());
                case 3: print(out, s, scanner.nextInt());
                case 4: s = append(s, scanner.next());
                default:
                    break;
            }
        }
    }

    private void print(BufferedWriter out, String s, int i) throws IOException {
        out.write(s.charAt(i - 1) + "\n");
    }

    private String delete(String s, int i) {
        return s.substring(0, s.length() - i);
    }

    private String append(String s, String next) {
        return s + next;
    }
}
