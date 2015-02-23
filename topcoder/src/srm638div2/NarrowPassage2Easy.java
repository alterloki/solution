package srm638div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// There is a narrow passage.
Inside the passage there are some wolves.
You are given a int[] size that contains the sizes of those wolves, from left to right.



The passage is so narrow that some pairs of wolves cannot pass by each other.
More precisely, two adjacent wolves may swap places if and only if the sum of their sizes is maxSizeSum or less.
Assuming that no wolves leave the passage, what is the number of different permutations of wolves in the passage?
Note that two wolves are considered different even if they have the same size.



Compute and return the number of permutations of wolves that can be obtained from their initial order by swapping a pair of wolves zero or more times.

DEFINITION
Class:NarrowPassage2Easy
Method:count
Parameters:int[], int
Returns:int
Method signature:int count(int[] size, int maxSizeSum)


CONSTRAINTS
-size will contain between 1 and 6 elements, inclusive.
-Each element in size will be between 1 and 1,000, inclusive.
-maxSizeSum will be between 1 and 1,000, inclusive.


EXAMPLES

0)
{1, 2, 3}
3

Returns: 2

From {1, 2, 3}, you can swap 1 and 2 to get {2, 1, 3}. But you can't get other permutations.

1)
{1, 2, 3}
1000

Returns: 6

Here you can swap any two adjacent wolves. Thus, all 3! = 6 permutations are possible.

2)
{1, 2, 3}
4

Returns: 3

You can get {1, 2, 3}, {2, 1, 3} and {2, 3, 1}.

3)
{1,1,1,1,1,1}
2

Returns: 720

All of these wolves are different, even though their sizes are the same. Thus, there are 6! different permutations possible.

4)
{2,4,6,1,3,5}
8

Returns: 60



5)
{1000}
1000

Returns: 1



*/
// END CUT HERE

import java.util.*;

public class NarrowPassage2Easy {
    private Set<String> set = new HashSet<>();
    private int maxSizeSum;
    private int[] size;

    public int count(int[] size, int maxSizeSum) {
        char[] arr = new char[size.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) i;
        }
        this.maxSizeSum = maxSizeSum;
        this.size = size;
        calculate(arr);
        return set.size();
    }

    private void calculate(char[] arr) {
        String s = new String(arr);
        if (!set.contains(s)) {
            set.add(s);
            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && swapPossible(arr, i - 1, i)) {
                    swap(arr, i - 1, i);
                    calculate(arr);
                    swap(arr, i - 1, i);
                }
                if (i < arr.length - 1 && swapPossible(arr, i + 1, i)) {
                    swap(arr, i + 1, i);
                    calculate(arr);
                    swap(arr, i + 1, i);
                }
            }
        }
    }

    private void swap(char[] arr, int i, int i1) {
        char c = arr[i];
        arr[i] = arr[i1];
        arr[i1] = c;
    }

    private boolean swapPossible(char[] arr, int i, int i1) {
        return size[arr[i]] + size[arr[i1]] <= maxSizeSum;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new NarrowPassage2Easy()).count(new int[]{1, 2, 3}, 3), 2);
            eq(1, (new NarrowPassage2Easy()).count(new int[]{1, 2, 3}, 1000), 6);
            eq(2, (new NarrowPassage2Easy()).count(new int[]{1, 2, 3}, 4), 3);
            eq(3, (new NarrowPassage2Easy()).count(new int[]{1, 1, 1, 1, 1, 1}, 2), 720);
            eq(4, (new NarrowPassage2Easy()).count(new int[]{2, 4, 6, 1, 3, 5}, 8), 60);
            eq(5, (new NarrowPassage2Easy()).count(new int[]{1000}, 1000), 1);
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
