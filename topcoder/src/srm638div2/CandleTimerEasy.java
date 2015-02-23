package srm638div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// You have a lot of candles.
The candles burn at a uniform rate: if you ignite a candle of length L, it will burn completely in L units of time.
You can also ignite a candle at both ends, which makes it burn twice as fast.



You have arranged some candles into the shape of a tree.
You want to use the tree to measure time.
At the beginning, you will ingite some leaves of the tree (all at the same time).
Then you will just wait and watch the flames spread across the entire tree.
(Whenever a flame reaches an inner node of the tree, it spreads to all branches that meet at that node.)
Note that you are not allowed to light new flames during the process.
The time you will measure is the time between the moment when you lighted the fire(s) and the moment when the last part of the tree finished burning.



You are given a description of the tree as three int[]s: a, b, and len, with N elements each.
The nodes of the tree are numbered 0 through N, inclusive.
For each valid i, there is a candle between the nodes a[i] and b[i] with length len[i].



Compute and return the number of different times you can measure when following the above procedure.

DEFINITION
Class:CandleTimerEasy
Method:differentTime
Parameters:int[], int[], int[]
Returns:int
Method signature:int differentTime(int[] A, int[] B, int[] len)


CONSTRAINTS
-A will contain between 1 and 19 elements, inclusive.
-A, B and len will contain same number of elements.
-Each element in A will be between 0 and |A|, inclusive.
-Each element in B will be between 0 and |A|, inclusive.
-Each element in len will be between 1 and 1000, inclusive.
-A, B and len will describe a tree.


EXAMPLES

0)
{0,1}
{1,2}
{10,1}

Returns: 2

This tree looks the same as a single candle of length 11. If we light it on one end, we will measure the time 11. If we light it on both ends, we will measure the time 5.5.

1)
{0,0,0}
{1,2,3}
{1,1,1}

Returns: 2

This time we have 3 ends. If we ignite all of them the time is 1, otherwise the time is 2.

2)
{0,0,0}
{1,2,3}
{1,2,3}

Returns: 4

We can get 4 different outcomes: 2.5, 3, 4, 5.

3)
{0,1,1,2,3,3,2,4}
{1,2,3,4,5,6,7,8}
{5,3,2,4,6,8,7,1}

Returns: 7



4)
{0,0,0,0}
{1,2,3,4}
{123,456,789,1000}

Returns: 8



5)
{0}
{1}
{1000}

Returns: 2



*/
// END CUT HERE

import java.util.*;
//TESTED
public class CandleTimerEasy {
    public int differentTime(int[] A, int[] B, int[] len) {
        Set<Double> times = new HashSet<>();
        int indexCount = A.length + 1;
        List[] tree = new List[indexCount];
        for (int i = 0; i < indexCount; i++) {
            tree[i] = new ArrayList();
        }
        int[][] edgeLength = new int[indexCount][indexCount];
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            tree[a].add(b);
            tree[b].add(a);
            edgeLength[a][b] = len[i];
            edgeLength[b][a] = len[i];
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < tree.length; i++) {
            List list = tree[i];
            if (list.size() == 1) {
                leaves.add(i);
            }
        }
        int combinations = 1 << leaves.size();
        for (int combination = 1; combination < combinations; combination++) {
            List<Integer> lightLeaves = new ArrayList<>();
            int index = 0;
            int temp = combination;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    lightLeaves.add(leaves.get(index));
                }
                temp >>= 1;
                index++;
            }
            double[] leafDistance = new double[indexCount];
            dijkstra(lightLeaves, tree, edgeLength, leafDistance);
            int maxIndex = 0;
            for (int i = 1; i < leafDistance.length; i++) {
                if (leafDistance[maxIndex] < leafDistance[i]) {
                    maxIndex = i;
                }
            }
            double maxEdge = 0;
            for (int i = 0; i < A.length; i++) {
                int a = A[i];
                int b = B[i];
                double aDist = leafDistance[a];
                double bDist = leafDistance[b];
                double edgeDist = 0;
                edgeDist = ((double)aDist + bDist + len[i]) / 2;
                if (edgeDist > maxEdge) {
                    maxEdge = edgeDist;
                }
            }
            times.add(maxEdge > leafDistance[maxIndex] ? maxEdge : leafDistance[maxIndex]);
        }
        return times.size();
    }

    private void dijkstra(List<Integer> leafs, List[] tree, int[][] edgeLength, final double[] leafDistance) {
        boolean[] visited = new boolean[tree.length];
        for (int i = 0; i < leafDistance.length; i++) {
            leafDistance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(tree.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(leafDistance[o1], leafDistance[o2]);
            }
        });
        for (Integer leaf : leafs) {
            pq.add(leaf);
            leafDistance[leaf] = 0;
        }
        while (!pq.isEmpty()) {
            Integer currentIndex = pq.poll();
            List children = tree[currentIndex];
            for (Object child : children) {
                Integer childIndex = (Integer) child;
                if (!visited[childIndex]) {
                    double newDistance = leafDistance[currentIndex] + edgeLength[currentIndex][childIndex];
                    if (newDistance < leafDistance[childIndex]) {
                        leafDistance[childIndex] = newDistance;
                        pq.remove(childIndex);
                        pq.add(childIndex);
                    }
                }
            }
            visited[currentIndex] = true;
        }
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new CandleTimerEasy()).differentTime(new int[]{0, 1}, new int[]{1, 2}, new int[]{10, 1}), 2);
            eq(1, (new CandleTimerEasy()).differentTime(new int[]{0, 0, 0}, new int[]{1, 2, 3}, new int[]{1, 1, 1}), 2);
            eq(2, (new CandleTimerEasy()).differentTime(new int[]{0, 0, 0}, new int[]{1, 2, 3}, new int[]{1, 2, 3}), 4);
            eq(3, (new CandleTimerEasy()).differentTime(new int[]{0, 1, 1, 2, 3, 3, 2, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{5, 3, 2, 4, 6, 8, 7, 1}), 7);
            eq(4, (new CandleTimerEasy()).differentTime(new int[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}, new int[]{123, 456, 789, 1000}), 8);
            eq(5, (new CandleTimerEasy()).differentTime(new int[]{0}, new int[]{1}, new int[]{1000}), 2);
            eq(6, (new CandleTimerEasy()).differentTime(
                    new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                    new int[]{0, 0, 2, 1, 1, 0, 5, 2, 8, 9, 1, 7, 7, 10, 14, 9},
                    new int[]{3, 3, 1, 3, 3, 1, 1, 3, 3, 2, 3, 1, 1, 2, 2, 3}), 14);
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
