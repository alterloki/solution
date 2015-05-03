package y2015.contest.r1a;

import java.io.*;
import java.util.*;

/**
 * TESTED
 * @author ashevenkov on 29.04.15.
 */
public class ProblemC {

    public static final String TITLE = "C-large-practice";
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
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = scanner.nextInt();
                y[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ":");
            out.newLine();
            /*out.write(Arrays.toString(x));
            out.newLine();
            out.write(Arrays.toString(y));
            out.newLine();*/
            int[] result = solveCase(x, y);
            for (int j = 0; j < result.length; j++) {
                out.write(Integer.toString(result[j]));
                out.newLine();
                out.flush();
            }
        }
    }

    private int[] solveCase(int[] x, int[] y) {
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = countForI(i, x, y);
        }
        return result;
    }

    private class Point {

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        int index = 0;
        int x;
        int y;
    }

    private int countForI(int i, int[] x, int[] y) {
        if(x.length == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        List<Point> points = new ArrayList<>();
        final double angle[] = new double[x.length];
        for (int j = 0; j < x.length; j++) {
            if (j != i) {
                points.add(new Point(j, x[j], y[j]));
                angle[j] = Math.atan2(y[j] - y[i], x[j] - x[i]);
                if (angle[j] < 0) {
                    angle[j] += 2 * Math.PI;
                }
            }
        }
        int s = points.size();
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(angle[o1.index], angle[o2.index]);
            }
        });
        if(s == 1) {
            return 0;
        }
        int from = 0;
        int to = -1;
        int prev = 0;
        while (from < s - 1) {
            int current = 0;
            if(to < 0) {
                to = from + 1;
                while (realAngle(to, points, angle) - angle[points.get(from).index] < Math.PI - 0.0000001) {
                    to++;
                    current++;
                }
            } else {
                from++;
                if(from < to) {
                    current = prev - 1;
                } else {
                    current = 0;
                }
                while (realAngle(to, points, angle) - angle[points.get(from).index] < Math.PI - 0.0000001) {
                    to++;
                    current++;
                }
            }
            if (current < min) {
                min = current;
            }
            prev = current;
        }
        return min;
    }

    private double realAngle(int to, List<Point> points, double[] angle) {
        if(to >= points.size()) {
            return angle[points.get(to % points.size()).index] + 2 * Math.PI;
        }
        return angle[points.get(to).index];
    }

    private int realIndex(int to, int s) {
        if(to >= s) {
            return to % s;
        }
        return to;
    }

}
