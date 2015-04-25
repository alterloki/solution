package srm619div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Shiny wants to give an award to one of the employees in her company.
However, all her employees are doing perfect work, so it's hard to pick the one that gets the award.
Therefore Shiny organized a game they will play to determine the winner.

At the beginning of the game, all N employees form a circle.
Then, they receive t-shirts with numbers 1 through N in clockwise order along the circle.
These numbers are never used in the game, we will just use them to identify the winner.

The game is played in turns.
The turns are numbered starting from 1.
In each turn, Shiny starts by standing in front of some employee (as specified below) and saying "one".
Then she moves clockwise along the circle to the next employee and says "two".
And so on, until the number she says reaches the threshold for that particular turn.
The threshold for turn number t is t^3.
(That is, the threshold is 1 for turn 1, 8 for turn 2, 27 for turn 3, and so on.)

At the end of each turn, the employee currently standing in front of Shiny (i.e., the one that received the number t^3) is eliminated.
In the very first round Shiny starts in front of the employee with the number 1 on their t-shirt.
In each of the following rounds, Shiny starts in front of the next employee clockwise from the one who just got eliminated.

When there is only one employee left in the game, the game ends and the employee wins the award.

You are given the int N.
Return the t-shirt number of the employee who gets the award.


DEFINITION
Class:ChooseTheBestOne
Method:countNumber
Parameters:int
Returns:int
Method signature:int countNumber(int N)


CONSTRAINTS
-N will between 1 and 5000, inclusive.


EXAMPLES

0)
3

Returns: 2

In the first round, Shiny stands in front of employee 1, says "one" and eliminates him.
In the second round, Shiny starts in front of employee 2. She says "one" to employee 2, "two" to
employee 3, "three" to employee 2 again, ..., and "eight" to employee 3. Thus, employee 3 
gets eliminated and employee 2 wins the award.


1)
6

Returns: 6



2)
10

Returns: 8



3)
1234

Returns: 341



*/
// END CUT HERE

import java.util.ArrayList;
import java.util.List;

public class ChooseTheBestOne {
    public int countNumber(int N) {
        List<Integer> employees = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            employees.add(i + 1);
        }
        int current = 0;
        for(long turn = 1; turn <= N - 1; turn++) {
            long steps = turn * turn * turn - 1;
            current += steps % employees.size();
            current = current % employees.size();
            employees.remove(current);
            if(current == employees.size()) {
                current = 0;
            }
        }
        return employees.iterator().next();
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new ChooseTheBestOne()).countNumber(3), 2);
            eq(1, (new ChooseTheBestOne()).countNumber(6), 6);
            eq(2, (new ChooseTheBestOne()).countNumber(10), 8);
            eq(3, (new ChooseTheBestOne()).countNumber(1234), 341);
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
