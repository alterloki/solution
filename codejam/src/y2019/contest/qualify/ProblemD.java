package y2019.contest.qualify;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int b = scanner.nextInt();
            int f = scanner.nextInt();
            int solve = new ProblemD().solve(n, b, f, scanner, out);
            if(solve < 0) {
                return;
            }
        }
        out.flush();
        out.close();
    }

    private class Interval {

        int from;
        int to;
        int b;

        public Interval(int from, int to, int b) {
            this.from = from;
            this.to = to;
            this.b = b;
        }

    }

    private int solve(int n, int b, int f, Scanner scanner, BufferedWriter out) throws IOException {
        List<Interval> intervals = new ArrayList<>();
        if(n > 16) {
            intervals = evaluate16Step(n, b, scanner, out);
        } else {
            intervals.add(new Interval(0, n, b));
        }
        int moreOneCount = 1;
        while(moreOneCount > 0) {
            String test = buildTest(intervals);
            out.write(test + "\n");
            out.flush();
            String testResult = scanner.next();
            moreOneCount = nextLevelSearch(testResult, intervals);
        }
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            if(interval.b > 0) {
                sb.append(interval.from).append(" ");
            }
        }
        String result = sb.toString();
        out.write(result.substring(0, result.length() - 1) + "\n");
        out.flush();
        int ret = scanner.nextInt();
        return ret;
    }

    private List<Interval> evaluate16Step(int n, int b, Scanner scanner, BufferedWriter out) throws IOException {
        StringBuilder input = new StringBuilder();
        int from = 0;
        boolean zeros = true;
        List<Interval> result = new ArrayList<>();
        while(n - from > 16) {
            result.add(new Interval(from, from + 16, 0));
            input.append(fillString(zeros ? '0' : '1', 16));
            zeros = !zeros;
            from += 16;
        }
        input.append(fillString(zeros ? '0' : '1', n - from));
        result.add(new Interval(from, n, 0));
        out.write(input.toString() + "\n");
        out.flush();
        String testResult = scanner.next();
        List<Integer> singles = new ArrayList<>();
        int count = 0;
        char prev = '0';
        for(int i = 0; i < testResult.length(); i++) {
            if(testResult.charAt(i) == prev) {
                count++;
            } else {
                singles.add(count);
                count = 1;
                prev = testResult.charAt(i);
            }
        }
        singles.add(count);
        for(int i = 0; i < result.size(); i++) {
            Interval interval = result.get(i);
            interval.b = interval.to - interval.from - singles.get(i);
        }
        return result;
    }

    private int nextLevelSearch(String testResult, List<Interval> intervals) {
        List<Interval> newIntervals = new ArrayList<>();
        int add = 0;
        int moreOneCount = 0;
        for (Interval interval : intervals) {
            int n = interval.to - interval.from;
            if(n > 1) {
                String currentString = testResult.substring(interval.from - add, interval.to - interval.b - add);
                int zeroLength = n / 2;
                int oneLength = n / 2 + n % 2;
                int zeros = countInString(currentString, '0');
                int ones = countInString(currentString, '1');
                newIntervals.add(new Interval(interval.from, interval.from + zeroLength, zeroLength - zeros));
                newIntervals.add(new Interval(interval.from + zeroLength, interval.to, oneLength - ones));
                if(zeroLength > 1) {
                    moreOneCount++;
                }
                if(oneLength > 1) {
                    moreOneCount++;
                }
            } else {
                newIntervals.add(interval);
            }
            add += interval.b;
        }
        intervals.clear();
        intervals.addAll(newIntervals);
        return moreOneCount;
    }

    private int countInString(String currentString, char c) {
        int result = 0;
        for(int i = 0; i < currentString.length(); i++) {
            if(currentString.charAt(i) == c) {
                result++;
            }
        }
        return result;
    }

    private String buildTest(List<Interval> intervals) {
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            int n = interval.to - interval.from;
            if(n > 1) {
                int aLength = n / 2;
                sb.append(fillString('0', aLength));
                int bLength = n / 2 + n % 2;
                sb.append(fillString('1', bLength));
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    private String fillString(char c, int aLength) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < aLength; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
