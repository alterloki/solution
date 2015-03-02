package srm639div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
//
Alice and Kirito just played a game.
The game consisted of a finite (possibly empty) sequence of turns.
You do not know the exact number of turns.
The turns were numbered starting from 1.
In each turn, exactly one of our two players won.
The winner of turn i scored i points.



You are given two longs x and y.
Find out whether it is possible that at the end of the game Alice had exactly x points and Kirito had exactly y points.
If it is possible, return the smallest number of turns Alice could have won.
If the given final result is not possible, return -1 instead.


DEFINITION
Class:AliceGameEasy
Method:findMinimumValue
Parameters:long, long
Returns:long
Method signature:long findMinimumValue(long x, long y)


CONSTRAINTS
-x and y will be between 0 and 1,000,000,000,000(10^12), inclusive.


EXAMPLES

0)
7
14

Returns: 2

This final result is possible.
One possibility is that Alice won turns 1, 2, and 4 (for 1+2+4 = 7 points) and Kirito won turns 3, 5, and 6 (for 3+5+6 = 14 points).
However, there are also some other possibilities in which Alice only won two of the six turns, so the correct answer is 2.

1)
10
0

Returns: 4

There must have been four turns and Alice must have won all four of them.

2)
932599670050
67400241741

Returns: 1047062

Watch out for integer overflow.

3)
7
13

Returns: -1



4)
0
0

Returns: 0



5)
100000
400500

Returns: 106



*/
// END CUT HERE

import java.util.*;
//TESTED
public class AliceGameEasy {
    public long findMinimumValue(long x, long y) {
        long sum = x + y;
        long N = (long) ((Math.sqrt(1 + 8 * sum) - 1) / 2);
        if (x + y != (N + 1) * N / 2) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int count = 0;
        while (x > N) {
            x -= N;
            N--;
            count++;
        }
        if (x <= N) {
            return count + 1;
        }
        return -1;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new AliceGameEasy()).findMinimumValue(7L, 14L), 2L);
            eq(1, (new AliceGameEasy()).findMinimumValue(10L, 0L), 4L);
            eq(2, (new AliceGameEasy()).findMinimumValue(932599670050L, 67400241741L), 1047062L);
            eq(3, (new AliceGameEasy()).findMinimumValue(7L, 13L), -1L);
            eq(4, (new AliceGameEasy()).findMinimumValue(0L, 0L), 0L);
            eq(5, (new AliceGameEasy()).findMinimumValue(100000L, 400500L), 106L);
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
