package srm640div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
In this problem, you are going to play a simple number game.
The rules of the game are as follows:

You have a single variable called x. Initially, x is set to 1.
In each step, you can change the value of x either to 2x or to 2x+1.
You are given a list of forbidden values. If at any moment your x is on the list, you lose the game.
You are also given a target value y. If at any moment your x is equal to y, you win the game. (Note that the previous item applies sooner: if y is forbidden, you lose the game when you reach it.)
If at any moment winning the game becomes impossible, you lose the game.




For example, assume that the forbidden values are 4 and 7, and the goal is 12.
You can win the game as follows: change x from 1 to 2*1+1=3, then from 3 to 2*3=6, and then from 6 to 2*6=12.



You are given a long[] table.
The elements of table are the forbidden values.



You are also given a int k.
Consider all possible goals y between 2 and (2^k)-1, inclusive.
For how many of these goals is it possible to win the game?
Compute and return the answer to that question.


DEFINITION
Class:NumberGameAgain
Method:solve
Parameters:int, long[]
Returns:long
Method signature:long solve(int k, long[] table)


CONSTRAINTS
-k will be between 2 and 40, inclusive.
-The number of elements in table will be between 0 and 20, inclusive.
-all numbers in table will be between 2 and 2^k - 1, inclusive.
-all numbers in table will be distinct.


EXAMPLES

0)
3
{2,4,6}

Returns: 2

There are three forbidden values: 2, 4, and 6.
As k=3, we are considering y between 2 and (2^3)-1 = 7.
This is how the game would end for each of these y's:

For y=2 we cannot win the game because 2 is forbidden.
For y=3 we can win the game: we change x from 1 to 3.
For y=4 we cannot win the game because 4 is forbidden.
For y=5 we cannot win the game. We would need to change x from 1 to 2 and then from 2 to 5, but we cannot do that because 2 is forbidden.
For y=6 we cannot win the game because 6 is forbidden.
For y=7 we can win the game: we change x from 1 to 3, and then from 3 to 7.

Thus, within the specified range there are two values of y for which we can win the game.


1)
5
{2,3}

Returns: 0

In this case, we will always reach a forbidden value after the very first step of the game. Therefore, there is no y for which we can win the game.

2)
5
{}

Returns: 30

With no forbidden values we can win this game for any y between 2 and 31, inclusive.

3)
40
{2,4,8,16,32141531,2324577,1099511627775,2222222222,33333333333,4444444444,2135}

Returns: 549755748288



4)
40
{}

Returns: 1099511627774



*/
// END CUT HERE

import java.util.*;
//TESTED
public class NumberGameAgain {

    class Pair implements Comparable<Pair> {
        long from;
        long to;

        Pair(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.from, o.from);
        }

        public boolean after(Pair pair1) {
            return this.from > pair1.from;
        }
    }

    public long solve(int k, long[] table) {
        Arrays.sort(table);
        long res = 0;
        long max = (long) Math.pow(2, k);
        List<Pair> plus = generatePairs(1, max);
        List<List<Pair>> minus = new ArrayList<>(table.length);
        for (int i = 0; i < table.length; i++) {
            minus.add(generatePairs(table[i], max));
        }
        for (List<Pair> minu : minus) {
            exclude(plus, minu);
        }
        for (Pair plu : plus) {
            res += (plu.to - plu.from);
        }
        return res;
    }

    private void exclude(List<Pair> plus, List<Pair> minu) {
        int i = 0;
        int j = 0;
        List<Pair> toAdd = new ArrayList<>();
        while (i < plus.size() && j < minu.size()) {
            Pair first = plus.get(i);
            Pair second = minu.get(j);
            if (intersects(first, second)) {
                if (first.after(second)) {
                    if (first.to > second.to) {
                        first.to = second.from;
                    } else {
                        first.to = first.from;
                    }
                } else {
                    if (second.to > first.to) {
                        first.to = second.from;
                    } else {
                        toAdd.add(new Pair(first.from, second.from));
                        first.from = second.to;
                    }
                }
                j++;
            } else if (first.from > second.from) {
                j++;
            } else {
                i++;
            }
        }
        plus.addAll(toAdd);
        Collections.sort(plus);
    }

    private boolean intersects(Pair pair, Pair pair1) {
        if (pair.after(pair1)) {
            if (pair1.to > pair.from) {
                return true;
            }
        } else {
            if (pair.to > pair1.from) {
                return true;
            }
        }
        return false;
    }

    private List<Pair> generatePairs(long k, long max) {
        List<Pair> list = new ArrayList<>();
        long counter = 1;
        if(k == 1) {
            counter = 2;
        }
        while (k * counter < max) {
            list.add(new Pair(counter * k, counter * k + counter));
            counter *= 2;
        }
        return list;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new NumberGameAgain()).solve(3, new long[]{2L, 4L, 6L}), 2L);
            eq(1, (new NumberGameAgain()).solve(5, new long[]{2L, 3L}), 0L);
            eq(2, (new NumberGameAgain()).solve(5, new long[]{}), 30L);
            eq(3, (new NumberGameAgain()).solve(40, new long[]{2L, 4L, 8L, 16L, 32141531L, 2324577L, 1099511627775L, 2222222222L, 33333333333L, 4444444444L, 2135L}), 549755748288L);
            eq(4, (new NumberGameAgain()).solve(40, new long[]{}), 1099511627774L);
            eq(5, (new NumberGameAgain()).solve(20, new long[]{88, 138390, 363924, 18595, 148, 179170, 29, 490195, 28, 67, 533, 980413, 1033224, 227290, 652478, 786172, 27, 5, 768}), 561093L);
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
