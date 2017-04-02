package y2016.contest.qualify;

import java.io.*;
import java.util.*;

/**
 * TESTED
 * @author ashevenkov 09.04.16 11:04.
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
            String s = scanner.next();
            out.write("Case #" + (i + 1) + ": " + solveCase1(s));
            out.newLine();
        }
    }

    private int solveCase(String s) {
        if(isGood(s)) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        map.put(s, 0);
        while(queue.size() > 0) {
            String cur = queue.poll();
            Integer pathLength = map.get(cur);
            for (int i = 1; i <= cur.length(); i++) {
                String reversed = reverse(cur, i);
                if (isGood(reversed)) {
                    return pathLength + 1;
                } else {
                    Integer toThis = map.get(reversed);
                    if (toThis == null) {
                        map.put(reversed, pathLength + 1);
                        queue.add(reversed);
                    } else {
                        if (toThis > pathLength + 1) {
                            map.put(reversed, pathLength + 1);
                            queue.add(reversed);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean isGood(String reversed) {
        for (char c : reversed.toCharArray()) {
            if(c == '-') {
                return false;
            }
        }
        return true;
    }

    private String reverse(String s, int i) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length()];
        for(int j = 0; j < i; j++) {
            newChars[j] = not(chars[i - j - 1]);
        }
        System.arraycopy(chars, i, newChars, i, s.length() - i);
        return new String(newChars);
    }

    private char not(char aChar) {
        if(aChar == '+') {
            return '-';
        } else {
            return '+';
        }
    }

    private int solveCase1(String s) {
        int result = 0;
        while(!isGood(s)) {
            char c = s.charAt(0);
            int to = s.indexOf(not(c));
            if(to < 0) {
                to = s.length();
            }
            s = reverse(s, to);
            result++;
        }
        return result;
    }
}
