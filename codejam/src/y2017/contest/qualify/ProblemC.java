package y2017.contest.qualify;

import java.io.*;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemC {

    public static final String TITLE = "C-large";
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
        new ProblemC().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            out.write("Case #" + (i + 1) + ": " + solveCase(n, k));
            out.newLine();
        }
    }

    private String solveCase(long n, long k) {
        long max = 0;
        long min = 0;
        TreeMap<Long, Long> map = new TreeMap<>(Comparator.<Long>reverseOrder());
        map.put(n, 1L);
        while(k > 0) {
            long[] stepResult = step(map, k);
            k = stepResult[0];
            max = stepResult[1];
            min = stepResult[2];
        }
        return max + " " + min;
    }

    private long[] step(TreeMap<Long, Long> map, long k) {
        long[] result = new long[3];
        Map.Entry<Long, Long> entry = map.entrySet().iterator().next();
        if(k > entry.getValue()) {
            result[0] = k - entry.getValue();
            map.remove(entry.getKey());
        }
        if(entry.getKey() % 2 == 0) {
            result[1] = entry.getKey() / 2;
            result[2] = entry.getKey() / 2 - 1;
        } else {
            result[1] = entry.getKey() / 2;
            result[2] = entry.getKey() / 2;
        }
        addToMap(map, result[1], entry.getValue());
        addToMap(map, result[2], entry.getValue());
        return result;
    }

    private void addToMap(TreeMap<Long, Long> map, long l, Long value) {
        Long count = map.get(l);
        if(count == null) {
            count = 0L;
        }
        count += value;
        map.put(l, count);
    }

}