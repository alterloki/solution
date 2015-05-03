/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 12.04.14
 * Time: 11:34
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.io.*;
import java.util.*;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemA {

    public static final String TITLE = "A-small-practice";
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
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int rowNum1 = scanner.nextInt();
            List<Set<Integer>> rows1 = new ArrayList<Set<Integer>>();
            for (int j = 0; j < 4; j++) {
                HashSet<Integer> row = new HashSet<Integer>();
                for (int k = 0; k < 4; k++) {
                    row.add(scanner.nextInt());
                }
                rows1.add(row);
            }
            int rowNum2 = scanner.nextInt();
            List<Set<Integer>> rows2 = new ArrayList<Set<Integer>>();
            for (int j = 0; j < 4; j++) {
                HashSet<Integer> row = new HashSet<Integer>();
                for (int k = 0; k < 4; k++) {
                    row.add(scanner.nextInt());
                }
                rows2.add(row);
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(rowNum1-1, rows1, rowNum2-1, rows2));
            out.newLine();
        }
    }

    private String solveCase(int rowNum1, List<Set<Integer>> rows1, int rowNum2, List<Set<Integer>> rows2) {
        Set<Integer> row1 = rows1.get(rowNum1);
        Set<Integer> row2 = rows2.get(rowNum2);
        row1.retainAll(row2);
        if(row1.size() == 0) {
            return "Volunteer cheated!";
        } else if(row1.size() > 1) {
            return "Bad magician!";
        } else {
            return Integer.toString(row1.iterator().next());
        }
    }
}
