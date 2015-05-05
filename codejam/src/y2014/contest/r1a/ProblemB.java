package y2014.contest.r1a;

import java.io.*;
import java.util.*;

/**
 * TESTED
 * @author ashevenkov on 04.05.15.
 */
public class ProblemB {

    public static final String TITLE = "B-large-practice";
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
            int n = scanner.nextInt();
            int[] x = new int[n - 1];
            int[] y = new int[n - 1];
            for(int j = 0; j < n - 1; j++) {
                x[j] = scanner.nextInt();
                y[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(n, x, y));
            out.newLine();
        }
    }

    private String solveCase(int n, int[] x, int[] y) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            List<Integer> xNodes = tree.get(x[i]);
            if(xNodes == null) {
                xNodes = new ArrayList<>();
                tree.put(x[i], xNodes);
            }
            xNodes.add(y[i]);
            List<Integer> yNodes = tree.get(y[i]);
            if(yNodes == null) {
                yNodes = new ArrayList<>();
                tree.put(y[i], yNodes);
            }
            yNodes.add(x[i]);
        }
        int maxSize = 0;
        for(int i = 1; i <= n; i++) {
            maxSize = Math.max(maxSize, getFullSize(-1, i, tree));
        }
        return Integer.toString(n - maxSize);
    }

    private int getFullSize(int parent, int i, Map<Integer, List<Integer>> tree) {
        List<Integer> children = tree.get(i);
        int count = 0;
        for (Integer child : children) {
            if(child != parent) {
                count++;
            }
        }
        if(count <= 1) {
            return 1;
        } else {
            List<Integer> sums = new ArrayList<>();
            for (Integer child : children) {
                if (child != parent) {
                    sums.add(getFullSize(i, child, tree));
                }
            }
            Collections.sort(sums);
            return 1 + sums.get(sums.size() - 1) + sums.get(sums.size() - 2);
        }
    }
}
