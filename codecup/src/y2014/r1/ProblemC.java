package y2014.r1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.04.14
 * Time: 12:46
 */
public class ProblemC {

    private static String INPUT = "2\n" +
            "5\n" +
            "1 2 2 1 3\n" +
            "8\n" +
            "1 2 3 1 4 2 3 5";

    public static void main(String[] args) throws IOException {
        new ProblemC().fire(new StringBufferInputStream(INPUT));
        //new ProblemC().fire(System.in);
    }

    private void fire(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        for (int i = 0; i < count; i++) {
            line = br.readLine();
            int n = Integer.parseInt(line);
            line = br.readLine();
            String[] parts = line.split(" ");
            int[] v = new int[n];
            for (int j = 0; j < parts.length; j++) {
                String part = parts[j];
                v[j] = Integer.parseInt(part);
            }
            System.out.println(solve(v));
        }
    }

    private String solve(int[] v) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> max = new ArrayList<Integer>();
        for (int i = 0; i < v.length; i++) {
            int num = v[i];
            if(i == 0) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                lists.add(l);
                max.add(num);
            } else {
                boolean needNew = true;
                for(int j = 0; j < max.size(); j++) {
                    Integer m = max.get(j);
                    if(m < num) {
                        lists.get(j).add(i);
                        max.set(j, num);
                        needNew = false;
                        break;
                    }
                }
                if(needNew) {
                    max.add(num);
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(i);
                    lists.add(l);
                }
            }
        }
        long[] result = new long[v.length];
        int from = 1;
        for(int i = lists.size() - 1; i >= 0; i--) {
            List<Integer> positions = lists.get(i);
            for (Integer position : positions) {
                result[position] = from;
                from++;
            }
        }
        return toString(result);
    }

    private String toString(long[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            long l = result[i];
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(l);
        }
        return sb.toString();
    }
}
