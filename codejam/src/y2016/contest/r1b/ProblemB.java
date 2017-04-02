package y2016.contest.r1b;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov 30.04.16 18:49.
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
        for (int i = 0; i < t; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            out.write("Case #" + (i + 1) + ": " + solveCase(s1, s2));
            out.newLine();
        }
    }

    private String solveCase(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        return resultToString(solveArrays(sc1, sc2));
    }

    private String resultToString(char[][] l) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l[0].length; i++) {
            sb.append(l[0][i]);
        }
        sb.append(' ');
        for (int i = 0; i < l[1].length; i++) {
            sb.append(l[1][i]);
        }
        return sb.toString();
    }

    private char[][] solveArrays(char[] sc1, char[] sc2) {
        long minDelta = Long.MAX_VALUE;
        char[] ns1 = Arrays.copyOf(sc1, sc1.length);
        char[] ns2 = Arrays.copyOf(sc2, sc2.length);
        char[][] result = new char[][] {ns1, ns2};
        for (int i = 0; i < sc1.length; i++) {
            if (sc1[i] == sc2[i]) {
                if (sc1[i] == '?') {
                    ns1[i] = '1';
                    ns2[i] = '0';
                    minDelta = checkAndFill(fillTheRest(ns2, ns1, i), minDelta, 1, 0, result);
                    ns1[i] = '0';
                    ns2[i] = '1';
                    minDelta = checkAndFill(fillTheRest(ns1, ns2, i), minDelta, 0, 1, result);
                    ns1[i] = '0';
                    ns2[i] = '0';
                    minDelta = checkAndFill(solveArrays(ns1, ns2), minDelta, 0, 1, result);
                    break;
                }
            } else {
                if (sc1[i] == '?') {
                    ns1[i] = sc2[i];
                    minDelta = checkAndFill(solveArrays(ns1, ns2), minDelta, 0, 1, result);
                    if (sc2[i] != '0') {
                        ns1[i] = (char) (sc2[i] - 1);
                        minDelta = checkAndFill(fillTheRest(ns1, ns2, i), minDelta, 0, 1, result);
                    }
                    if (sc2[i] != '9') {
                        ns1[i] = (char) (sc2[i] + 1);
                        minDelta = checkAndFill(fillTheRest(ns2, ns1, i), minDelta, 1, 0, result);
                    }
                } else if (sc2[i] == '?') {
                    ns2[i] = sc1[i];
                    minDelta = checkAndFill(solveArrays(ns1, ns2), minDelta, 0, 1, result);
                    if (sc1[i] != '9') {
                        ns2[i] = (char) (sc1[i] + 1);
                        minDelta = checkAndFill(fillTheRest(ns1, ns2, i), minDelta, 0, 1, result);
                    }
                    if (sc1[i] != '0') {
                        ns2[i] = (char) (sc1[i] - 1);
                        minDelta = checkAndFill(fillTheRest(ns2, ns1, i), minDelta, 1, 0, result);
                    }
                } else {
                    if(sc1[i] < sc2[i]) {
                        minDelta = checkAndFill(fillTheRest(ns1, ns2, i), minDelta, 0, 1, result);
                    } else {
                        minDelta = checkAndFill(fillTheRest(ns2, ns1, i), minDelta, 1, 0, result);
                    }
                }
                break;
            }
        }
        return result;
    }

    private char[][] fillTheRest(char[] n1, char[] n2, int i) {
        char[] ns1 = Arrays.copyOf(n1, n1.length);
        char[] ns2 = Arrays.copyOf(n2, n2.length);
        for(int j = i + 1; j < ns1.length; j++) {
            if(ns1[j] == '?') {
                ns1[j] = '9';
            }
            if(ns2[j] == '?') {
                ns2[j] = '0';
            }
        }
        return new char[][] {ns1, ns2};
    }

    private long checkAndFill(char[][] tResult , long minDelta, int i1, int i2, char[][] result) {
        long t1 = Long.parseLong(new String(tResult[0]));
        long t2 = Long.parseLong(new String(tResult[1]));
        long tDelta = Math.abs(t1 - t2);
        if(tDelta < minDelta) {
            result[i1] = tResult[0];
            result[i2] = tResult[1];
            return tDelta;
        } else if(tDelta == minDelta){
            long r1 = Long.parseLong(new String(result[0]));
            long r2 = Long.parseLong(new String(result[0]));
            if(i1 == 0) {
                if(t1 < r1 || t1 == r1 && t2 < r2) {
                    result[0] = tResult[0];
                    result[1] = tResult[1];
                }
            } else {
                if(t2 < r2 || t2 == r2 && t1 < r1) {
                    result[0] = tResult[1];
                    result[1] = tResult[0];
                }
            }
            return minDelta;
        } else {
            return minDelta;
        }
    }

}
