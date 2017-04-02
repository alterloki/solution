/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 16.04.14
 * Time: 21:02
 */
package y2008.contest.r1b;

import common.ParseUtil;

import java.util.Arrays;

/**
 * @author ashevenkov
 */
public class ProblemA {

    static String INPUT =
            "4\n" +
                    "2 2\n" +
                    "2 1\n" +
                    "2 4\n" +
                    "2 1 1 6\n" +
                    "10 4\n" +
                    "25 20 9 100\n" +
                    "1 4\n" +
                    "1 1 1 1";

    public static void main(String[] args) {
        //new ProblemA().run(INPUT);
        new ProblemA().run(ParseUtil.parseFile("A-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            long a = Long.parseLong(parts[0]);
            int nSizes = Integer.parseInt(parts[1]);
            line = lines[ln++];
            parts = line.split(" ");
            long[] motes = new long[parts.length];
            for (int j = 0; j < parts.length; j++) {
                String part = parts[j];
                motes[j] = Long.parseLong(part);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(a, motes));
        }
    }

    private String solve(long a, long[] motes) {
        long sum = a;
        long result = 0;
        if(a == 1) {
            result = motes.length;
        } else {
            Arrays.sort(motes);
            for (int i = 0; i < motes.length; i++) {
                long mote = motes[i];
                if(mote < sum) {
                    sum += mote;
                } else {
                    double l = Math.log(((double)mote - 1)/((double)sum - 1))/Math.log(2);
                    long k = (long)Math.floor(l) + 1;
                    if(k > motes.length - i) {
                        result += motes.length - i;
                        break;
                    } else {
                        long sk = (long)Math.pow(2, k) * (sum - 1) + 1;
                        sum = sk + mote;
                        result += k;
                    }
                }
            }
            result = Math.min(result, motes.length);
        }
        return Long.toString(result);
    }
}
