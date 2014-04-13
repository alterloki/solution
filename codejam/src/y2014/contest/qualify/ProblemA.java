/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 12.04.14
 * Time: 11:34
 */
package y2014.contest.qualify;

import common.ParseUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ashevenkov
 */
public class ProblemA {

    static String INPUT =
            "3\n" +
                    "2\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16\n" +
                    "3\n" +
                    "1 2 5 4\n" +
                    "3 11 6 15\n" +
                    "9 10 7 12\n" +
                    "13 14 8 16\n" +
                    "2\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16\n" +
                    "2\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16\n" +
                    "2\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16\n" +
                    "3\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16";

    public static void main(String[] args) {
        //new ProblemA().run(INPUT);
        new ProblemA().run(ParseUtil.parseFile("A-small-attempt0.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            int rowNum1 = Integer.parseInt(line);
            List<Set<Integer>> rows1 = new ArrayList<Set<Integer>>();
            for (int j = 0; j < 4; j++) {
                String vector1 = lines[ln++];
                HashSet<Integer> row = new HashSet<Integer>();
                String[] parts = vector1.split(" ");
                for (int k = 0; k < parts.length; k++) {
                    String part = parts[k];
                    row.add(Integer.parseInt(part));
                }
                rows1.add(row);
            }
            line = lines[ln++];
            int rowNum2 = Integer.parseInt(line);
            List<Set<Integer>> rows2 = new ArrayList<Set<Integer>>();
            for (int j = 0; j < 4; j++) {
                String vector1 = lines[ln++];
                HashSet<Integer> row = new HashSet<Integer>();
                String[] parts = vector1.split(" ");
                for (int k = 0; k < parts.length; k++) {
                    String part = parts[k];
                    row.add(Integer.parseInt(part));
                }
                rows2.add(row);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(rowNum1-1, rows1, rowNum2-1, rows2));
        }
    }

    private String solve(int rowNum1, List<Set<Integer>> rows1, int rowNum2, List<Set<Integer>> rows2) {
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
