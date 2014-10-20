package srm632div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
You have some cards, each containing a positive integer.
You are given a int[] d.
Each element of d is one of those integers.
The integers are not necessarily distinct.



You are also given an int goodValue.
You are interested in non-empty subsets of cards with the following property:
The product of integers written on those cards is exactly equal to goodValue.



Let X be the number of subsets with the above property.
Compute and return the value (X modulo 1,000,000,007).


DEFINITION
Class:GoodSubset
Method:numberOfSubsets
Parameters:int, int[]
Returns:int
Method signature:int numberOfSubsets(int goodValue, int[] d)


CONSTRAINTS
-goodValue will be between 1 and 2,000,000,000, inclusive.
-d will contain between 1 and 100 elements, inclusive.
-Each element of d will be between 1 and 2,000,000,000, inclusive.


EXAMPLES

0)
10
{2,3,4,5}

Returns: 1

There is only one good subset:{2,5}.

1)
6
{2,3,4,5,6}

Returns: 2

There are two good subsets: {2,3} and {6}.

2)
1
{1,1,1}

Returns: 7

All non-empty subsets of this set of cards are good.

3)
12
{1,2,3,4,5,6,7,8,9,10,11,12}

Returns: 6



4)
5
{1,2,3,4}

Returns: 0



*/
// END CUT HERE

import java.util.*;
//TESTED
public class GoodSubset {

    private int[] d;
    Map[] maps = new Map[101];

    public int numberOfSubsets(int goodValue, int[] d) {
        this.d = d;
        return f(goodValue, d.length - 1) - (goodValue == 1 ? 1 : 0);
    }

    //f(x, t) = f(x/d[t-1],t-1) + f(x, t-1)
    private int f(int goodValue, int i) {
        if (i == -1) {
            if (goodValue == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        if (maps[i] == null) {
            maps[i] = new HashMap<Integer, Integer>();
        }
        Integer cached = (Integer) maps[i].get(goodValue);
        if (cached != null) {
            return cached;
        } else {
            int res1 = f(goodValue, i - 1);
            int res2 = 0;
            if (goodValue % d[i] == 0) {
                res2 = f(goodValue / d[i], i - 1);
            }
            int r = (res1 + res2) % 1000000007;
            maps[i].put(goodValue, r);
            return r;
        }
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new GoodSubset()).numberOfSubsets(10, new int[]{2, 3, 4, 5}), 1);
            eq(1, (new GoodSubset()).numberOfSubsets(6, new int[]{2, 3, 4, 5, 6}), 2);
            eq(2, (new GoodSubset()).numberOfSubsets(1, new int[]{1, 1, 1}), 7);
            eq(3, (new GoodSubset()).numberOfSubsets(12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}), 6);
            eq(4, (new GoodSubset()).numberOfSubsets(5, new int[]{1, 2, 3, 4}), 0);
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
