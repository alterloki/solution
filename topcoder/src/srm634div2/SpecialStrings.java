package srm634div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
A string S is called special if it satisfies the following two properties:

Each character in S is either '0' or '1'.
Whenever S = UV where both U and V are nonempty strings, U is strictly smaller than V in lexicographic order.




For example, the string S = "00101" is special because we have "0" < "0101", "00" < "101", "001" < "01", and "0010" < "1".



You are given a String current that is guaranteed to be special.
Let N be the length of current.
Consider the lexicographically sorted list of all special strings of length N.
Compute and return the string that comes immediatelly after current in this list.
If current happens to be the last string in the list, return an empty String instead.


DEFINITION
Class:SpecialStrings
Method:findNext
Parameters:String
Returns:String
Method signature:String findNext(String current)


NOTES
-Given two different strings U and V, the string U precedes the string V in lexicographic order if one of two conditions is satisfied: Either U is a proper prefix of V, or there is an integer x such that U and V have the same first x characters, and the x+1th character in U is smaller than the x+1th character in V.


CONSTRAINTS
-current will contain between 1 and 50 characters, inclusive.
-current will be a special string.


EXAMPLES

0)
"01"

Returns: ""

"01" is the only special string of length 2.

1)
"00101"

Returns: "00111"

The special strings of length 5 are "00001", "00011", "00101", "00111", "01011", "01111".

2)
"0010111"

Returns: "0011011"



3)
"000010001001011"

Returns: "000010001001101"



4)
"01101111011110111"

Returns: "01101111011111111"



*/
// END CUT HERE

import java.util.*;
//TESTED
public class SpecialStrings {
    public String findNext(String current) {
        String res = "";
        for (int i = current.length() - 1; i >= 0; i--) {
            String s = new String(current);
            char[] original = s.toCharArray();
            if (original[i] == '0') {
                for (int j = i; j < current.length(); j++) {
                    original[i] = '1';
                }
                int index = i;
                String prev = new String(original);
                if (isSpecial(prev)) {
                    return findMin(original, i + 1, current);
                }
            }
        }
        return res;
    }

    private String findMin(char[] original, int i, String current) {
        String prev = new String(original);
        if(i == original.length) {
            return prev;
        }
        original[i] = '0';
        String zeroString = new String(original);
        if(!zeroString.equals(current)) {
            if(isSpecial(zeroString)) {
                return findMin(original, i + 1, current);
            } else {
                original[i] = '1';
                return findMin(original, i + 1, current);
            }
        } else {
            return prev;
        }
    }

    private boolean isSpecial(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(0, i).compareTo(s.substring(i, s.length())) >= 0) {
                return false;
            }
        }
        return true;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new SpecialStrings()).findNext("01"), "");
            eq(1, (new SpecialStrings()).findNext("00101"), "00111");
            eq(2, (new SpecialStrings()).findNext("0010111"), "0011011");
            eq(3, (new SpecialStrings()).findNext("000010001001011"), "000010001001101");
            eq(4, (new SpecialStrings()).findNext("01101111011110111"), "01101111011111111");
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
