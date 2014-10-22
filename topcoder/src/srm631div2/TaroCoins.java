package srm631div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Cat Taro likes coins. For any non-negative integer K, he has exactly two coins of value 2^K (i.e., two to the power of K).




You are given a long N.
Return the number of different ways Taro can represent the value N with coins that he has.
(Two representations are considered different if there is a value that occurs a different number of times in the representations.)


DEFINITION
Class:TaroCoins
Method:getNumber
Parameters:long
Returns:long
Method signature:long getNumber(long N)


NOTES
-The answer will always fit in a signed 64-bit integer.


CONSTRAINTS
-N will be between 1 and 1,000,000,000,000,000,000 (10^18), inclusive.


EXAMPLES

0)
1

Returns: 1

The only possible way to represent N in this case is to use one coin of value 1.

1)
6

Returns: 3

The following three representations are possible in this case: {1, 1, 2, 2}, {1, 1, 4} and {2, 4}

2)
47

Returns: 2



3)
256

Returns: 9



4)
8489289

Returns: 6853



5)
1000000000

Returns: 73411



*/
// END CUT HERE

import java.util.*;
//TESTED
public class TaroCoins {

    private long[][] cache = new long[63][4];

    public long getNumber(long N) {
        for (int i = 0; i < 63; i++) {
            for (int j = 0; j < 4; j++) {
                cache[i][j] = -1;
            }
        }
        return solve(N, 61, 0);
    }

    private long solve(long n, int i, int owed) {
        if (cache[i][owed] >= 0) {
            return cache[i][owed];
        }
        long res = 0;
        int b = (n & 1L << i) > 0 ? 1 : 0;
        int currentOwed = owed + b;
        if (i == 0) {
            if (currentOwed > 2) {
                res = 0;
            } else {
                res = 1;
            }
        } else {
            if (currentOwed == 0) {
                res = solve(n, i - 1, 0);
            } else if (currentOwed == 1 || currentOwed == 2) {
                res = solve(n, i - 1, 0) + solve(n, i - 1, 2);
            } else {
                res = solve(n, i - 1, 2);
            }
        }
        cache[i][owed] = res;
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new TaroCoins()).getNumber(1L), 1L);
            eq(1, (new TaroCoins()).getNumber(6L), 3L);
            eq(2, (new TaroCoins()).getNumber(47L), 2L);
            eq(3, (new TaroCoins()).getNumber(256L), 9L);
            eq(4, (new TaroCoins()).getNumber(8489289L), 6853L);
            eq(5, (new TaroCoins()).getNumber(1000000000L), 73411L);
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
