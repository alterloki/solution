package y2014.r1;

import java.io.*;
import java.util.*;

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
        //new y2015.r1.ProblemC().fire(System.in);
    }

    public void fire(InputStream is) throws IOException {
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
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            int i1 = v[i];
            positions.add(new int[]{i1, i});
        }
        Collections.sort(positions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) {
                    return 1;
                } else if(o1[0] < o2[0]){
                    return -1;
                } else {
                    return o1[1] > o2[1] ? -1 : 1;
                }
            }
        });
        long[] result = new long[v.length];
        for(int i = 0; i < v.length; i++) {
            result[positions.get(i)[1]] = i + 1;
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
