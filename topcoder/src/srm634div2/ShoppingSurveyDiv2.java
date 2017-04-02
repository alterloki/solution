package srm634div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
A store sells M different items, conveniently numbered 0 through M-1.
For a shopping survey you interviewed N customers.
Each customer responded to the survey with a list of items they've bought.
Each customer bought at most one of each item.
It is possible that some customers did not buy anything at all.



After collecting the responses, you've summed up the results and found that s[i] people have bought item i.
Due to an unfortunate accident, you've then lost the actual survey responses.
All you have left are the values s[i] you computed.



You are now supposed to report the number of big shoppers among the survey respondents.
A big shopper is defined as a customer who has bought all M items.
Of course, having lost the detailed responses, you might be unable to determine the actual number of big shoppers.



You are given the int N and the int[] s with M elements.
Compute and return the smallest possible number of big shoppers.



DEFINITION
Class:ShoppingSurveyDiv2
Method:minValue
Parameters:int, int[]
Returns:int
Method signature:int minValue(int N, int[] s)


CONSTRAINTS
-N will be between 1 and 100, inclusive.
-s will contain between 1 and 100 elements, inclusive.
-Each element in s will be between 0 and N, inclusive.


EXAMPLES

0)
5
{3, 3}

Returns: 1


There are 5 customers and 2 items in the store.
Each of the items was bought by three of the customers.
Since there are five people and a total of six bought items, we must have at least one big shopper.
And we can easily verify that there could have been exactly one big shopper and four other customers who have bought one item each.

1)
100
{97}

Returns: 97



2)
10
{9, 9, 9, 9, 9}

Returns: 5



3)
7
{1, 2, 3}

Returns: 0



4)
5
{3, 3, 3}

Returns: 0



*/
// END CUT HERE

import java.util.*;
//TESTED
public class ShoppingSurveyDiv2 {
    public int minValue(int N, int[] s) {
        int sum = 0;
        for (int j = 0; j < s.length; j++) {
            sum += s[j];
        }
        return Math.max(0, sum - (s.length - 1) * N);
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new ShoppingSurveyDiv2()).minValue(5, new int[]{3, 3}), 1);
            eq(1, (new ShoppingSurveyDiv2()).minValue(100, new int[]{97}), 97);
            eq(2, (new ShoppingSurveyDiv2()).minValue(10, new int[]{9, 9, 9, 9, 9}), 5);
            eq(3, (new ShoppingSurveyDiv2()).minValue(7, new int[]{1, 2, 3}), 0);
            eq(4, (new ShoppingSurveyDiv2()).minValue(5, new int[]{3, 3, 3}), 0);
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
