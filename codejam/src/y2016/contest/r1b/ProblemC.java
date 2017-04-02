package y2016.contest.r1b;

import java.io.*;
import java.util.*;

/**
 * @author ashevenkov 30.04.16 18:49.
 */
public class ProblemC {

    public static final String TITLE = "C-small-practice";
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
            int n = scanner.nextInt();
            String[][] strs = new String[n][];
            for(int j = 0; j < n; j++) {
                String s1 = scanner.next();
                String s2 = scanner.next();
                strs[j] = new String[2];
                strs[j][0] = s1;
                strs[j][1] = s2;
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(strs));
            out.newLine();
        }
    }

    private String solveCase(String[][] strs) {
        int minCount = Integer.MAX_VALUE;
        List<int[]> indexes = toInts(strs);
        Set<Integer> firstS = toSet(indexes, 0);
        Set<Integer> secondS = toSet(indexes, 1);
        long count = (long) Math.pow(2, indexes.size());
        for(long i = 1; i < count; i++) {
            Set<Integer> cur1 = new HashSet<>();
            Set<Integer> cur2 = new HashSet<>();
            int currentCount = addCurrent(i, cur1, cur2, indexes);
            if(cur1.equals(firstS) && cur2.equals(secondS)) {
                if(currentCount < minCount) {
                    minCount = currentCount;
                }
            }
        }
        return Integer.toString(strs.length - minCount);
    }

    private int addCurrent(long i, Set<Integer> cur1, Set<Integer> cur2, List<int[]> indexes) {
        int index = 0;
        int count = 0;
        while(i > 0) {
            if((i & 1) == 1) {
                cur1.add(indexes.get(index)[0]);
                cur2.add(indexes.get(index)[1]);
                count++;
            }
            index++;
            i = i >> 1;
        }
        return count;
    }

    private Set<Integer> toSet(List<int[]> indexes, int i) {
        Set<Integer> set = new HashSet<>();
        for (int[] index : indexes) {
            set.add(index[i]);
        }
        return set;
    }

    private List<int[]> toInts(String[][] strs) {
        int counter = 0;
        List<int[]> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String[] str : strs) {
            int[] r = new int[2];
            Integer i1 = map.get(str[0]);
            if (i1 == null) {
                i1 = ++counter;
                map.put(str[0], i1);
            }
            r[0] = i1;
            Integer i2 = map.get(str[1]);
            if (i2 == null) {
                i2 = ++counter;
                map.put(str[1], i2);
            }
            r[1] = i2;
            result.add(r);
        }
        return result;
    }

}
