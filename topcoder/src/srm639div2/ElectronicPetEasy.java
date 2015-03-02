package srm639div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Kirino has found a game in which she has to feed electronic pets.
There are two pets in the game.
You are given six ints st1,p1,t1,st2,p2,t2.
To win the game, Kirino must satisfy the following rules:

She must feed her first pet for the first time precisely at the time st1.
There must be exactly p1 seconds between any two consecutive feedings of the first pet.
She must feed the first pet exactly t1 times.
She must feed her second pet for the first time precisely at the time st2.
There must be exactly p2 seconds between any two consecutive feedings of the second pet.
She must feed the second pet exactly t2 times.




Feeding the pets is easy if Kirino never needs to feed both pets at the same time.
Return "Easy" (quotes for clarity) if feeding the pets is easy for the given inputs.
Otherwise, return "Difficult".
Note that the return value is case-sensitive.


DEFINITION
Class:ElectronicPetEasy
Method:isDifficult
Parameters:int, int, int, int, int, int
Returns:String
Method signature:String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2)


CONSTRAINTS
-st1, p1, t1, st2, p2, and t2 will be between 1 and 1,000, inclusive.


EXAMPLES

0)
3
3
3
5
2
3

Returns: "Difficult"

Kirino must feed her first pet at the times 3, 6, and 9.
She must feed her second pet at the times 5, 7, and 9.
Feeding these two pets is difficult because she needs to feed both of them at the same time (at time 9).

1)
3
3
3
5
2
2

Returns: "Easy"

Kirino must feed her first pet at 3, 6, and 9, and her second pet at 5 and 7.
As all of these times are distinct, feeding these two pets is easy.

2)
1
4
7
1
4
7

Returns: "Difficult"



3)
1
1000
1000
2
1000
1000

Returns: "Easy"



4)
1
1
1
2
2
2

Returns: "Easy"



*/
// END CUT HERE

import java.util.*;
//TESTED
public class ElectronicPetEasy {
    public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
        Set<Integer> first = new HashSet<>();
        int time = st1;
        int count = 0;
        while (count < t1) {
            first.add(time);
            count++;
            time += p1;
        }
        time = st2;
        count = 0;
        while (count < t2) {
            if(first.contains(time)) {
                return "Difficult";
            }
            count++;
            time += p2;
        }
        return "Easy";
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new ElectronicPetEasy()).isDifficult(3, 3, 3, 5, 2, 3), "Difficult");
            eq(1, (new ElectronicPetEasy()).isDifficult(3, 3, 3, 5, 2, 2), "Easy");
            eq(2, (new ElectronicPetEasy()).isDifficult(1, 4, 7, 1, 4, 7), "Difficult");
            eq(3, (new ElectronicPetEasy()).isDifficult(1, 1000, 1000, 2, 1000, 1000), "Easy");
            eq(4, (new ElectronicPetEasy()).isDifficult(1, 1, 1, 2, 2, 2), "Easy");
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
