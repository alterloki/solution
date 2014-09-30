package srm144div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Computers tend to store dates and times as single numbers which represent the number of seconds or milliseconds since a particular date.  Your task in this problem is to write a method whatTime, which takes an int, seconds, representing the number of seconds since midnight on some day, and returns a String formatted as "<H>:<M>:<S>".  Here, <H> represents the number of complete hours since midnight, <M> represents the number of complete minutes since the last complete hour ended, and <S> represents the number of seconds since the last complete minute ended.  Each of <H>, <M>, and <S> should be an integer, with no extra leading 0's.  Thus, if seconds is 0, you should return "0:0:0", while if seconds is 3661, you should return "1:1:1".

DEFINITION
Class:Time
Method:whatTime
Parameters:int
Returns:String
Method signature:String whatTime(int seconds)


CONSTRAINTS
-seconds will be between 0 and 24*60*60 - 1 = 86399, inclusive.


EXAMPLES

0)
0

Returns: "0:0:0"

1)
3661

Returns: "1:1:1"

2)
5436

Returns: "1:30:36"

3)
86399

Returns: "23:59:59"

*/
// END CUT HERE
//TESTED
public class Time {
    public String whatTime(int seconds) {
        String res = "";
        int h = 0;
        int m = 0;
        int s = 0;
        h = seconds / 3600;
        seconds -= h * 3600;
        m = seconds / 60;
        s = seconds - m * 60;
        return Integer.toString(h) + ":" + Integer.toString(m) + ":" + Integer.toString(s);
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new Time()).whatTime(0), "0:0:0");
            eq(1, (new Time()).whatTime(3661), "1:1:1");
            eq(2, (new Time()).whatTime(5436), "1:30:36");
            eq(3, (new Time()).whatTime(86399), "23:59:59");
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
