package srm633div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Frog Suwako lives on a two-dimensional plane.
She likes to jump.
Currently, she is located in the point (0, 0).
She would like to reach the point (x, y).
You are given the ints x and y.



Suwako wants to reach the desired destination in a specific way: using a series of jumps with pre-determined lengths.
You are given these lengths in a int[] jumpLenghts.
For example, if jumpLengths = { 2, 5 }, Suwako must make a jump of length exactly 2, followed by a jump of length exactly 5.



Note that Suwako can jump onto arbitrary points in the plane, they are not required to have integer coordinates.
Return "Able" (quotes for clarity) if Suwako is able to reach her desired destination from (0, 0) using the desired sequence of jump lengths.
Otherwise, return "Not able".

DEFINITION
Class:Jumping
Method:ableToGet
Parameters:int, int, int[]
Returns:String
Method signature:String ableToGet(int x, int y, int[] jumpLengths)


CONSTRAINTS
-x will be between -1,000 and 1,000, inclusive.
-y will be between -1,000 and 1,000, inclusive.
-len will contain between 1 and 50 elements, inclusive.
-Each element in len will be between 1 and 1,000, inclusive.


EXAMPLES

0)
5
4
{2, 5}

Returns: "Able"

One possibility is to jump from (0, 0) to (2, 0), and then from (2, 0) to (5, 4).

1)
3
4
{4}

Returns: "Not able"

The distance from (0, 0) to (3, 4) is 5. You cannot get there using a single jump of length 4 - it is too short.

2)
3
4
{6}

Returns: "Not able"

The distance from (0, 0) to (3, 4) is 5. You cannot get there using a single jump of length 6 - it is too long.

3)
0
1
{100, 100}

Returns: "Able"

Here, one possible solution looks as follows: Let t = sqrt(100*100 - 0.5*0.5). Suwoko will make her first jump from (0, 0) to (t, 0.5), and her second jump from (t, 0.5) to (0, 1).

4)
300
400
{500}

Returns: "Able"



5)
11
12
{1,2,3,4,5,6,7,8,9,10}

Returns: "Able"



6)
11
12
{1,2,3,4,5,6,7,8,9,100}

Returns: "Not able"



*/
// END CUT HERE

import java.util.*;
//TESTED
public class Jumping {
    public String ableToGet(int x, int y, int[] jumpLengths) {
        String res = "Able";
        double[] lines = new double[jumpLengths.length + 1];
        lines[0] = Math.sqrt((double) x * x + (double) y * y);
        for (int i = 0; i < jumpLengths.length; i++) {
            lines[i + 1] = jumpLengths[i];
        }
        for (int i = 0; i < lines.length; i++) {
            double line = lines[i];
            double otherSum = 0;
            for (int j = 0; j < i; j++) {
                otherSum += lines[j];
            }
            for (int j = i + 1; j < lines.length; j++) {
                otherSum += lines[j];
            }
            if(line > otherSum) {
                return "Not able";
            }
        }
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new Jumping()).ableToGet(5, 4, new int[]{2, 5}), "Able");
            eq(1, (new Jumping()).ableToGet(3, 4, new int[]{4}), "Not able");
            eq(2, (new Jumping()).ableToGet(3, 4, new int[]{6}), "Not able");
            eq(3, (new Jumping()).ableToGet(0, 1, new int[]{100, 100}), "Able");
            eq(4, (new Jumping()).ableToGet(300, 400, new int[]{500}), "Able");
            eq(5, (new Jumping()).ableToGet(11, 12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), "Able");
            eq(6, (new Jumping()).ableToGet(11, 12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 100}), "Not able");
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
