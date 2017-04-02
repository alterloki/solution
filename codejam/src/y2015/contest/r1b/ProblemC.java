package y2015.contest.r1b;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov 12.04.16 1:18.
 */
public class ProblemC {

    public static final String TITLE = "B-large-practice";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

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
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<int[]> coords = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                int[] coord = new int[2];
                coord[0] = scanner.nextInt();
                coord[1] = scanner.nextInt();
                coords.add(coord);
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(coords));
            out.newLine();
        }
    }

    private String solveCase(List<int[]> coords) {
        int[] result = new int[coords.size()];

        return resultToString(result);
    }

    private String resultToString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if(i < result.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
