package srm144div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// You work for an electric company, and the power goes out in a rather large apartment complex with a lot of irate tenants. You isolate the problem to a network of sewers underneath the complex with a step-up transformer at every junction in the maze of ducts. Before the power can be restored, every transformer must be checked for proper operation and fixed if necessary. To make things worse, the sewer ducts are arranged as a tree with the root of the tree at the entrance to the network of sewers. This means that in order to get from one transformer to the next, there will be a lot of backtracking through the long and claustrophobic ducts because there are no shortcuts between junctions. Furthermore, it's a Sunday; you only have one available technician on duty to search the sewer network for the bad transformers. Your supervisor wants to know how quickly you can get the power back on; he's so impatient that he wants the power back on the moment the technician okays the last transformer, without even waiting for the technician to exit the sewers first.
 You will be given three int[]'s: fromJunction, toJunction, and ductLength that represents each sewer duct. Duct i starts at junction (fromJunction[i]) and leads to junction (toJunction[i]). ductlength[i] represents the amount of minutes it takes for the technician to traverse the duct connecting fromJunction[i] and toJunction[i]. Consider the amount of time it takes for your technician to check/repair the transformer to be instantaneous. Your technician will start at junction 0 which is the root of the sewer system. Your goal is to calculate the minimum number of minutes it will take for your technician to check all of the transformers. You will return an int that represents this minimum number of minutes.

DEFINITION
Class:PowerOutage
Method:estimateTimeOut
Parameters:int[], int[], int[]
Returns:int
Method signature:int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength)


CONSTRAINTS
-fromJunction will contain between 1 and 50 elements, inclusive.
-toJunction will contain between 1 and 50 elements, inclusive.
-ductLength will contain between 1 and 50 elements, inclusive.
-toJunction, fromJunction, and ductLength must all contain the same number of elements.
-Every element of fromJunction will be between 0 and 49 inclusive.
-Every element of toJunction will be between 1 and 49 inclusive.
-fromJunction[i] will be less than toJunction[i] for all valid values of i.
-Every (fromJunction[i],toJunction[i]) pair will be unique for all valid values of i.
-Every element of ductlength will be between 1 and 2000000 inclusive.
-The graph represented by the set of edges (fromJunction[i],toJunction[i]) will never contain a loop, and all junctions can be reached from junction 0.


EXAMPLES

0)
{0}
{1}
{10}

Returns: 10

The simplest sewer system possible. Your technician would first check transformer 0, travel to junction 1 and check transformer 1, completing his check. This will take 10 minutes.

1)
{0,1,0}
{1,2,3}
{10,10,10}

Returns: 40

Starting at junction 0, if the technician travels to junction 3 first, then backtracks to 0 and travels to junction 1 and then junction 2, all four transformers can be checked in 40 minutes, which is the minimum.

2)
{0,0,0,1,4}
{1,3,4,2,5}
{10,10,100,10,5}

Returns: 165

Traveling in the order 0-1-2-1-0-3-0-4-5 results in a time of 165 minutes which is the minimum.

3)
{0,0,0,1,4,4,6,7,7,7,20}
{1,3,4,2,5,6,7,20,9,10,31}
{10,10,100,10,5,1,1,100,1,1,5}

Returns: 281

Visiting junctions in the order 0-3-0-1-2-1-0-4-5-4-6-7-9-7-10-7-8-11 is optimal, which takes  (10+10+10+10+10+10+100+5+5+1+1+1+1+1+1+100+5) or 281 minutes.

4)
{0,0,0,0,0}
{1,2,3,4,5}
{100,200,300,400,500}

Returns: 2500

*/
// END CUT HERE

import java.util.*;

public class PowerOutage {

    private class Node {
        int index;
        int price;
        int underPrice;
        int sumPrice;
        Node innerNode = null;

        private Node(int index, int price) {
            this.index = index;
            this.price = price;
            this.underPrice = price;
            this.sumPrice = price;
        }
    }

    public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
        int res = 0;
        //build tree
        Map<Integer, List<Node>> tree = new HashMap<Integer, List<Node>>();
        for(int i = 0; i < fromJunction.length; i++) {
            int from = fromJunction[i];
            int to = toJunction[i];
            List<Node> children = tree.get(from);
            if(children == null) {
                children = new ArrayList<Node>();
                tree.put(from, children);
            }
            children.add(new Node(to, ductLength[i]));
        }
        //count price to the end
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(0, 0));
        while(stack.size() > 0) {
            Node node = stack.pop();
            if(node.innerNode != null) {
                List<Node> children = tree.get(node.index);
                int max = 0;
                for(Node child : children) {
                    if(child.underPrice > max) {
                        max = child.underPrice;
                    }
                    node.innerNode.underPrice = max;
                }
            } else {
                List<Node> children = tree.get(node.index);
                if(children != null) {
                    Node container = new Node(node.index, node.price);
                    container.innerNode = node;
                    stack.push(container);
                    for(int i = children.size() - 1; i >= 0; i--) {
                        Node child = children.get(i);
                        child.sumPrice += node.sumPrice;
                        stack.push(child);
                    }
                } else {
                    node.underPrice = node.sumPrice;
                }
            }
        }
        //count power
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Node> current = new Stack<Node>();
        current.push(new Node(0, 0));
        while(current.size() > 0 && visited.size() < toJunction.length + 1) {
            Node node = current.pop();
            if(node.index >= 0) {
                List<Node> children = tree.get(node.index);
                res += node.price;
                current.push(new Node(-1, node.price));
                if(children != null) {
                    Collections.sort(children, new Comparator<Node>() {
                        @Override
                        public int compare(Node o1, Node o2) {
                            return o1.underPrice > o2.underPrice ? 1 : (o1.underPrice == o2.underPrice ? 0 : -1);
                        }
                    });
                    for(int i = children.size() - 1; i >= 0; i--) {
                        Node child = children.get(i);
                        current.push(child);
                    }
                }
                visited.add(node.index);
            } else {
                res += node.price;
            }
        }
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new PowerOutage()).estimateTimeOut(new int[]{0}, new int[]{1}, new int[]{10}), 10);
            eq(1, (new PowerOutage()).estimateTimeOut(new int[]{0, 1, 0}, new int[]{1, 2, 3}, new int[]{10, 10, 10}), 40);
            eq(2, (new PowerOutage()).estimateTimeOut(new int[]{0, 0, 0, 1, 4}, new int[]{1, 3, 4, 2, 5}, new int[]{10, 10, 100, 10, 5}), 165);
            eq(3, (new PowerOutage()).estimateTimeOut(new int[]{0, 0, 0, 1, 4, 4, 6, 7, 7, 7, 20}, new int[]{1, 3, 4, 2, 5, 6, 7, 20, 9, 10, 31}, new int[]{10, 10, 100, 10, 5, 1, 1, 100, 1, 1, 5}), 281);
            eq(4, (new PowerOutage()).estimateTimeOut(new int[]{0, 0, 0, 0, 0}, new int[]{1, 2, 3, 4, 5}, new int[]{100, 200, 300, 400, 500}), 2500);
            eq(5, (new PowerOutage()).estimateTimeOut(
                    new int[]{0, 0, 1, 1, 0, 2, 3, 5, 0, 8 , 4 , 0 , 7 , 11, 0 , 7 , 4 , 1 , 10, 0 , 14, 1 , 14, 2 , 5 , 22, 17, 20, 11, 4 , 9 , 17, 22, 22, 11, 34},
                    new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36},
                    new int[]{1018364, 366729, 38720, 309940, 930370, 1180695, 184916, 1682446, 1464885, 1419914, 627577, 1694249, 3555, 1141976, 1605618, 354404, 1442970, 1889613, 1017314, 1745357, 799406, 549771, 1861235, 592722, 930547, 1314662, 1026768, 271675, 781098, 170104, 1424080, 324735, 394783, 1118990, 351154, 1637251}),
                    62287142);
        } catch(Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if(a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(!a[i].equals(b[i])) {
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
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
