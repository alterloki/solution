package y2014.r1;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.04.14
 * Time: 12:29
 */
public class ProblemB {

    private static final String INPUT =
            "1\n" +
                    "2 3 2 2";

    public static void main(String[] args) throws IOException {
        //new y2015.r1.ProblemB().fire(System.in);
        new ProblemB().fire(new StringBufferInputStream(INPUT));
    }

    public void fire(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        for (int i = 0; i < count; i++) {
            line = br.readLine();
            String[] parts = line.split(" ");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            long k = Long.parseLong(parts[2]);
            long t = Long.parseLong(parts[3]);
            System.out.println(solve(x, y, k, t));
        }
    }

    private String solve(long x, long y, long k, long t) {
        if (y == 1) {
            return Long.toString(x + t);
        }
        long a = x % y;
        long b = y - a;
        if (a == 0) {
            if (t < k) {
                k = t;
            }
            return Long.toString(x + k * y + t - k);
        } else {
            long r1;
            long ka, kb;
            if (t < k - 1) {
                ka = t + 1;
            } else {
                ka = k;
            }
            if(t - b < k) {
                kb = t - b;
            } else {
                kb = k;
            }
            if (t > b) {
                r1 = x + kb * y + t - kb;
            } else {
                r1 = x + t;
            }
            long r2 = x - a + ka * y + t - ka + 1;
            return Long.toString(Math.max(r1, r2));
        }
    }
}
