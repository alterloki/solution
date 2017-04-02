package srm633div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Your task is to find n positive integers.
We will label them x[0] through x[n-1].



We will give you some information about these integers.
Namely, for some pairs of integers we will tell you both their greatest common divisor (GCD) and their least common multiple (LCM).



You are given the int n and four int[]s: A, B, G, and L.
These int[]s will all have the same number of elements.
Their meaning is as follows:
For each valid i, the integers x[ A[i] ] and x[ B[i] ] must have the greatest common divisor G[i] and the least common multiple L[i].



Return "Solution exists" (quotes for clarity) if there is at least one way to choose x[0] through x[n-1] so that all requirements are satisfied.
Otherwise, return "Solution does not exist".

DEFINITION
Class:GCDLCMEasy
Method:possible
Parameters:int, int[], int[], int[], int[]
Returns:String
Method signature:String possible(int n, int[] A, int[] B, int[] G, int[] L)


NOTES
-The greatest common divisor (GCD) of two positive integers x and y is the largest positive integer z such that z divides x and at the same time z divides y.
-The least common multiple (LCM) of two positive integers x and y is the smallest positive integer z such that x divides z and at the same time y divides z.
-For example, the GCD of 10 and 15 is 5, and the LCM of 10 and 15 is 30.


CONSTRAINTS
-n will be between 1 and 500, inclusive.
-A will contain between 1 and 500 elements, inclusive.
-A and B will contain the same number of elements.
-A and G will contain the same number of elements.
-A and L will contain the same number of elements.
-Each element in A will be between 0 and n-1, inclusive.
-Each element in B will be between 0 and n-1, inclusive.
-For each i, A[i] and B[i] will be different.
-Each element in G will be between 1 and 10,000, inclusive.
-Each element in L will be between 1 and 10,000, inclusive.


EXAMPLES

0)
4
{0,1,2,3}
{1,2,3,0}
{6,6,6,6}
{12,12,12,12}

Returns: "Solution exists"

We have 4 unknown integers: x[0], x[1], x[2], and x[3].
The given A, B, G, and L encode the following information:

The GCD of x[0] and x[1] must be 6 and their LCM must be 12.
The GCD of x[1] and x[2] must be 6 and their LCM must be 12.
The GCD of x[2] and x[3] must be 6 and their LCM must be 12.
The GCD of x[3] and x[0] must be 6 and their LCM must be 12.

There are two valid solutions.
In one of them, x[0] = x[2] = 6 and x[1] = x[3] = 12.

1)
5
{0,1,2,3,4}
{1,2,3,4,0}
{6,6,6,6,6}
{12,12,12,12,12}

Returns: "Solution does not exist"



2)
2
{0,0}
{1,1}
{123,123}
{456,789}

Returns: "Solution does not exist"

The LCM of x[0] and x[1] cannot be 456 and 789 at the same time.

3)
2
{0}
{1}
{1234}
{5678}

Returns: "Solution does not exist"

The LCM of x[0] and x[1] must always be a multiple of their GCD.

4)
6
{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4}
{1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5}
{2, 2, 3, 3, 1, 2, 5, 1, 5, 1, 7, 7, 3, 5, 7}
{30, 42, 30, 42, 210, 70, 30, 210, 70, 210, 42, 70, 105, 105, 105}


Returns: "Solution exists"

There is one solution: {6, 10, 14, 15, 21, 35}.

5)
500
{0}
{1}
{10000}
{10000}

Returns: "Solution exists"



*/
// END CUT HERE

import java.util.*;
//TESTED
public class GCDLCMEasy {

    private class Edge {
        private int b;
        private int g;
        private int l;

        private Edge(int b, int g, int l) {
            this.b = b;
            this.g = g;
            this.l = l;
        }
    }

    private int gcd(int a, int b) {
        int d = a % b;
        return d > 0 ? gcd(b, d) : b;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public String possible(int n, int[] A, int[] B, int[] G, int[] L) {
        int[] numbers = new int[n];
        Map<Integer, List<Edge>> numbersMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            addToMap(numbersMap, A[i], B[i], G[i], L[i]);
            addToMap(numbersMap, B[i], A[i], G[i], L[i]);
        }
        Arrays.fill(numbers, -1);
        for (int i = 0; i < n; i++) {
            if (numbers[i] < 0) {
                boolean good = false;
                for (int j = 1; j <= 10000; j++) {
                    clearNumbersFrom(numbers, i, numbersMap);
                    if (dfs(i, j, numbersMap, numbers)) {
                        good = true;
                        break;
                    }
                }
                if (!good) {
                    return "Solution does not exist";
                }
            }
        }
        return "Solution exists";
    }

    private boolean dfs(int num, int value, Map<Integer, List<Edge>> numbersMap, int[] numbers) {
        numbers[num] = value;
        List<Edge> neighbours = numbersMap.get(num);
        if (neighbours == null) {
            return true;
        }
        for (Edge neighbour : neighbours) {
            int second = numbers[neighbour.b];
            if (second > 0) {
                if (gcd(value, second) != neighbour.g || lcm(value, second) != neighbour.l) {
                    return false;
                }
            } else {
                int value1 = neighbour.l * neighbour.g / value;
                if (value1 == 0) {
                    return false;
                }
                if(!dfs(neighbour.b, value1, numbersMap, numbers)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void clearNumbersFrom(int[] numbers, int i, Map<Integer, List<Edge>> numbersMap) {
        if (numbers[i] > 0) {
            numbers[i] = -1;
            List<Edge> edges = numbersMap.get(i);
            for (Edge edge : edges) {
                clearNumbersFrom(numbers, edge.b, numbersMap);
            }
        }
    }


    private void addToMap(Map<Integer, List<Edge>> numbersMap, int a, int b, int g, int l) {
        List<Edge> list = numbersMap.get(a);
        if (list == null) {
            list = new ArrayList<>();
            numbersMap.put(a, list);
        }
        list.add(new Edge(b, g, l));
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new GCDLCMEasy()).possible(4, new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 0}, new int[]{6, 6, 6, 6}, new int[]{12, 12, 12, 12}), "Solution exists");
            eq(1, (new GCDLCMEasy()).possible(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 0}, new int[]{6, 6, 6, 6, 6}, new int[]{12, 12, 12, 12, 12}), "Solution does not exist");
            eq(2, (new GCDLCMEasy()).possible(2, new int[]{0, 0}, new int[]{1, 1}, new int[]{123, 123}, new int[]{456, 789}), "Solution does not exist");
            eq(3, (new GCDLCMEasy()).possible(2, new int[]{0}, new int[]{1}, new int[]{1234}, new int[]{5678}), "Solution does not exist");
            eq(4, (new GCDLCMEasy()).possible(6, new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4}, new int[]{1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5}, new int[]{2, 2, 3, 3, 1, 2, 5, 1, 5, 1, 7, 7, 3, 5, 7}, new int[]{30, 42, 30, 42, 210, 70, 30, 210, 70, 210, 42, 70, 105, 105, 105}
              ), "Solution exists");
            eq(5, (new GCDLCMEasy()).possible(500, new int[]{0}, new int[]{1}, new int[]{10000}, new int[]{10000}), "Solution exists");

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
