/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.04.14
 * Time: 18:52
 */
package y2013.contest.r1a;

import common.ParseUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ashevenkov
 */
public class ProblemB {

    static String INPUT =
            "5\n" +
                    "5 2 2\n" +
                    "2 1\n" +
                    "5 2 2\n" +
                    "1 2\n" +
                    "3 3 4\n" +
                    "4 1 3 5\n" +
                    "3 1 5\n" +
                    "3 1 5 4 2\n" +
                    "9350183 8416606 1\n" +
                    "5340254";

    public static void main(String[] args) {
        //new ProblemB().run(INPUT);
        new ProblemB().run(ParseUtil.parseFile("B-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            int e = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);
            line = lines[ln++];
            parts = line.split(" ");
            int[] v = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                v[j] = Integer.parseInt(parts[j]);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(e, r, v));
        }
    }

    public static class Point {
        int start;
        int spent;
        boolean fixed = false;

        public Point(int start, int spent) {
            this.start = start;
            this.spent = spent;
        }

        int getFinish() {
            return start - spent;
        }
    }

    private String solve(int e, int r, int[] v) {
        Point[] points = new Point[v.length];
        if (r >= e) {
            r = e;
            for (int i = 0; i < v.length; i++) {
                points[i] = new Point(e, r);
            }
            return String.valueOf(multiply(points, v));
        }
        for (int i = 0; i < v.length; i++) {
            points[i] = new Point(e, 0);
        }
        if (r < e) {
            //optimize spent
            int[] sortedIndexes = sort(v);
            for (int i = 0; i < sortedIndexes.length; i++) {
                int sortedIndex = sortedIndexes[i];
                optimize(points, sortedIndex, e, r);
            }
        }
        return String.valueOf(multiply(points, v));
    }

    private void optimize(Point[] points, int sortedIndex, int e, int r) {
        if (sortedIndex == points.length - 1) {
            Point point = points[sortedIndex];
            point.spent = point.start;
            point.fixed = true;
        } else {
            int ind = sortedIndex;
            int fulledIndex = sortedIndex + (int) Math.floor((double) e / (double) r);
            boolean fixed = false;
            boolean finish = false;
            while (!fixed && !finish) {
                ind++;
                Point point = points[ind];
                if(point.fixed) {
                    fixed = true;
                } else if(ind == points.length - 1 || ind == fulledIndex) {
                    finish = true;
                }
            }
            if (fixed) {
                points[sortedIndex].spent = r * (ind - sortedIndex) + points[sortedIndex].start - points[ind].start;
                if(points[sortedIndex].spent < 0) {
                    points[sortedIndex].spent = 0;
                }
                for (int i = sortedIndex + 1; i < ind; i++) {
                    points[i].start = points[i - 1].getFinish() + r;
                }
            } else {
                points[sortedIndex].spent = points[sortedIndex].start;
                for (int i = sortedIndex + 1; i <= ind; i++) {
                    points[i].start = points[i - 1].getFinish() + r;
                }
            }
            points[sortedIndex].fixed = true;
        }
    }

    class A implements Comparable<A> {
        int index;
        int weight;

        A(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(A o) {
            return weight > o.weight ? 1 : (weight == o.weight ? 0 : -1);
        }
    }

    private int[] sort(int[] v) {
        List<A> a = new ArrayList<A>();
        for (int i = 0; i < v.length; i++) {
            a.add(new A(i, v[i]));

        }
        Collections.sort(a);
        Collections.reverse(a);
        int[] result = new int[v.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a.get(i).index;
        }
        return result;
    }

    private long multiply(Point[] points, int[] v) {
        long result = 0;
        for (int i = 0; i < v.length; i++) {
            result += (long)points[i].spent * (long)v[i];
        }
        return result;
    }

}
