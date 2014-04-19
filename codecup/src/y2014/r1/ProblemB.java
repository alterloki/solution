package y2014.r1;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.04.14
 * Time: 12:29
 */
public class ProblemB {

    public static void main(String[] args) throws IOException {
        new ProblemB().fire(System.in);
    }

    private void fire(InputStream is) throws IOException {
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
        if(y == 1) {
            return Long.toString(x + t);
        }
        if(x % y == 0) {
            x++;
            t--;
        }
        if(t < k) {
            k = t + 1;
        }
        long s = (x - x % y) * y;
        long result = s * y + k * y;
        if(t >= k) {
            result = result + (t - k + 1);
        }
        return Long.toString(result);
    }
}
