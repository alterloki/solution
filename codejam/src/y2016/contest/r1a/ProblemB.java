package y2016.contest.r1a;

import java.io.*;
import java.util.*;

/**
 * //TESTED
 * @author ashevenkov 30.04.16 18:49.
 */
public class ProblemB {

    public static final String TITLE = "A-large-practice";
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
            List<int[]> lines = new ArrayList<>();
            for(int j = 0; j < 2 * n - 1; j++) {
                int[] line = new int[n];
                for(int k = 0; k < n; k++) {
                    line[k] = scanner.nextInt();
                }
                lines.add(line);
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(n, lines));
            out.newLine();
        }
    }

    private String solveCase(int n, List<int[]> lines) {
        int[][] grid = new int[n][];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new int[n];
        }
        fill(lines, grid, 0);
        return null;
    }

    private void fill(List<int[]> lines, int[][] grid, int index) {
        Set<Integer> curLines = new HashSet<>();
        int minHeight = Integer.MAX_VALUE;
        for(int i = 0; i < lines.size(); i++) {
            int[] line = lines.get(i);
            int curHeight = line[index];
            if(curHeight == minHeight) {
                curLines.add(i);
            } else if(curHeight < minHeight) {
                curLines.clear();
                curLines.add(i);
                minHeight = curHeight;
            }
        }

    }


}
