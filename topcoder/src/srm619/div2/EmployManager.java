package srm619.div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Shiny wants to hire some managers for her company.
There are N candidates, numbered 0 through N-1.
She can employ any subset of these candidates, including possibly none or all of them.

For each of the candidates we know an amount in dollars Shiny must pay if she wants to hire that candidate.
You are given a int[] value with N elements.
For each i, value[i] is the amount in dollars Shiny has to pay if she wants to hire candidate i.

For each pair i < j of candidates we also know a value E(i,j) with the following meaning:

If both i and j are employed, the company will earn E(i,j) dollars.
However, if neither i nor j are employed, they will cooperate to harm the company, which will cost the company E(i,j) dollars.

If one of them is employed and the other isn't, nothing happens.
All the values E(i,j) are between 0 and 9, inclusive.

For your convenience, we also define E(i,i)=0 and E(j,i)=E(i,j) for all i and j.

You are given the above values E(i,j) encoded as a String[] earning with N elements, each consisting of N characters.
For each i and j, earning[i][j] is the character ('0'-'9') that represents the value E(i,j).

You are given the int[] value and the String[] earning.
Compute and return the largest total profit (i.e., earnings minus costs) the company can obtain by hiring a suitable subset of candidates.



DEFINITION
Class:EmployManager
Method:maximumEarnings
Parameters:int[], String[]
Returns:int
Method signature:int maximumEarnings(int[] value, String[] earning)


CONSTRAINTS
-value will contain between 1 and 50 elements, inclusive.
-earning will contain the same number of elements as value.
-The length of each element of earning will be the same as the number of elements in value.
-Each character in each element of earning will be a digit ('0'-'9').
-Each element of value will be between 0 and 1000, inclusive.
-For each i, earning[i][i] will be '0'.
-For each i and j, earning[i][j] will be equal to earning[j][i].


EXAMPLES

0)
{1, 1}
{"02", "20"}

Returns: 0

Hiring both managers is the optimal solution in this example.

1)
{2, 2}
{"01", "10"}

Returns: -1

Here it is best not to hire any manager.

2)
{1, 2, 3, 4}
{"0121", "1021", "2201", "1110"}

Returns: -1



3)
{2, 2, 0, 1, 4, 0, 1, 0, 0, 4}
{"0100451253",  "1010518123",  "0102989242",  "0020093171",  "4590045480",  "5189400676",  "1893500826",  "2121468008",  "5247872007",  "3321066870"}

Returns: 156



*/
// END CUT HERE

import java.util.HashSet;
import java.util.Set;

public class EmployManager {
    public int maximumEarnings(int[] value, String[] earning) {
        int res = 0;
        int sumValue = 0;
        for(int i = 0; i < value.length; i++) {
            sumValue += value[i];
        }
        int sumEraning = 0;
        for(int i = 0; i < earning.length; i++) {
            String s = earning[i];
            char[] ca = s.toCharArray();
            for(int j = 0; j < i; j++) {
                char c = ca[j];
                sumEraning += c - '0';
            }
        }
        int maxProfit = sumEraning - sumValue;
        boolean cont = true;
        Set<Integer> removed = new HashSet<Integer>();
        while(cont) {
            for(int toRemove = 0; toRemove < value.length; toRemove++) {
                if(!removed.contains(toRemove)) {
                    int curValue = sumValue - value[toRemove];
                    int curEarning = sumEraning;
                    for(int i = 0; i < value.length; i++) {
                        int e = earning[i].toCharArray()[toRemove] - '0';
                        curEarning -= e;
                    }
                    int curProfit = curEarning - curValue;
                    if(curProfit > maxProfit) {
                        maxProfit = curProfit;
                        removed.add(toRemove);
                        sumEraning = curEarning;
                        sumValue = curValue;
                        cont = true;
                        break;
                    }
                }
                cont = false;
            }
        }
        res = maxProfit;
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new EmployManager()).maximumEarnings(new int[]{1, 1}, new String[]{"02", "20"}), 0);
            eq(1, (new EmployManager()).maximumEarnings(new int[]{2, 2}, new String[]{"01", "10"}), -1);
            eq(2, (new EmployManager()).maximumEarnings(new int[]{1, 2, 3, 4}, new String[]{"0121", "1021", "2201", "1110"}), -1);
            eq(3, (new EmployManager()).maximumEarnings(new int[]{2, 2, 0, 1, 4, 0, 1, 0, 0, 4}, new String[]{"0100451253", "1010518123", "0102989242", "0020093171", "4590045480", "5189400676", "1893500826", "2121468008", "5247872007", "3321066870"}), 156);
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
