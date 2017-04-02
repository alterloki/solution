/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 23.02.14
 * Time: 1:42
 */
package y2008.contest.r1a;

import common.ParseUtil;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p1
 *
 * @author ashevenkov
 */
public class ProblemB {

    static String INPUT =
            "2\n" +
                    "5\n" +
                    "3\n" +
                    "1 1 1\n" +
                    "2 1 0 2 0\n" +
                    "1 5 0\n" +
                    "1\n" +
                    "2\n" +
                    "1 1 0\n" +
                    "1 1 1";


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //new ProblemB().run(INPUT);
        new ProblemB().run(ParseUtil.parseFile("B-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int c = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < c; i++) {
            int nFlavours = Integer.parseInt(lines[ln++]);
            int nCustomers = Integer.parseInt(lines[ln++]);
            int[][][] preferences = new int[nCustomers][][];
            for (int j = 0; j < nCustomers; j++) {
                String customerLine = lines[ln++];
                String[] parts = customerLine.split(" ");
                int prefNum = Integer.parseInt(parts[0]);
                preferences[j] = new int[prefNum][];
                for (int k = 0; k < prefNum; k++) {
                    int flavPos = Integer.parseInt(parts[2 * k + 1]);
                    int flavType = Integer.parseInt(parts[2 * k + 2]);
                    preferences[j][k] = new int[2];
                    preferences[j][k][0] = flavPos - 1;
                    preferences[j][k][1] = flavType;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(nFlavours, preferences));
        }
    }

    /*
        If not happy and have 1 then put one on this position.
        If no 1 then - impossible.
     */
    private String solve(int nFlavours, int[][][] preferences) {
        int[] current = new int[nFlavours];
        int happyCustomers = 0;
        int customersNum = preferences.length;
        while (happyCustomers < customersNum) {
            for (int i = 0; i < preferences.length; i++) {
                int[][] customer = preferences[i];
                boolean haveGoodTaste = false;
                int maltedPos = -1;
                for (int[] pref : customer) {
                    if (pref[1] == 1) {
                        maltedPos = pref[0];
                    }
                    if (current[pref[0]] == pref[1]) {
                        haveGoodTaste = true;
                        break;
                    }
                }
                if (!haveGoodTaste) {
                    if (maltedPos < 0) {
                        return "IMPOSSIBLE";
                    } else {
                        current[maltedPos] = 1;
                        happyCustomers = 0;
                        break;
                    }
                } else {
                    happyCustomers++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current.length; i++) {
            int b = current[i];
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(Integer.toString(b));
        }
        return sb.toString();
    }

}
