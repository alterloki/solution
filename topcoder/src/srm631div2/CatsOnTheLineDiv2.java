package srm631div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
//
There are some cats sitting on a straight line that goes from the left to the right.
You are given two int[]s position and count.
For each valid i, there are count[i] cats initially sitting at the point position[i].




During each minute, each cat chooses and performs one of three possible actions: it may stay in its place, move one unit to the left (i.e., from x to x-1), or move one unit to the right (i.e., from x to x+1).
(Note that there are no restrictions. In particular, different cats that are currently at the same point may make different choices.)




You are also given an int time.
The goal is to rearrange the cats in such a way that each point contains at most one cat.
Return "Possible" if it's possible to achive the goal in time minutes, and "Impossible" otherwise (quotes for clarity).


DEFINITION
Class:CatsOnTheLineDiv2
Method:getAnswer
Parameters:int[], int[], int
Returns:String
Method signature:String getAnswer(int[] position, int[] count, int time)


CONSTRAINTS
-position will contain between 1 and 50 elements, inclusive.
-position and count will contain the same number of elements.
-Each element of position will be between -1000 and 1000, inclusive.
-All elements of position will be distinct.
-Each element of count will be between 1 and 1000, inclusive.
-time will be between 0 and 1000, inclusive.


EXAMPLES

0)
{0}
{7}
3

Returns: "Possible"

There are 7 cats sitting at the origin in this case. There are also 7 different points that cats can reach in 3 minutes, so each cat can occupy a unique point. Thus, the answer is "Possible".

1)
{0}
{8}
2

Returns: "Impossible"

Unlike the first test case, in this case there are 8 cats for 7 available points. Thus, the answer is "Impossible".

2)
{0, 1}
{3, 1}
0

Returns: "Impossible"



3)
{5, 0, 2}
{2, 3, 5}
2

Returns: "Impossible"



4)
{5, 1, -10, 7, 12, 2, 10, 20}
{3, 4, 2, 7, 1, 4, 3, 4}
6

Returns: "Possible"



*/
// END CUT HERE
//TESTED
import java.util.*;
public class CatsOnTheLineDiv2 {
    public String getAnswer(int[] position, int[] count, int time) {
        String res = "Possible";
        int minCatElement = -2001;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], count[i]);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int pos = entry.getKey();
            int cats = entry.getValue();
            int minC = pos - time;
            int maxC = pos + time;
            if(minC <= minCatElement) {
                minC = minCatElement + 1;
            }
            if(maxC - minC + 1 < cats) {
                return "Impossible";
            }
            minCatElement = minC + cats - 1;
        }
        return "Possible";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            //eq(0,(new CatsOnTheLineDiv2()).getAnswer(new int[] {0}, new int[] {7}, 3),"Possible");
            //eq(1,(new CatsOnTheLineDiv2()).getAnswer(new int[] {0}, new int[] {8}, 2),"Impossible");
            //eq(2,(new CatsOnTheLineDiv2()).getAnswer(new int[] {0, 1}, new int[] {3, 1}, 0),"Impossible");
            //eq(3,(new CatsOnTheLineDiv2()).getAnswer(new int[] {5, 0, 2}, new int[] {2, 3, 5}, 2),"Impossible");
            //eq(4,(new CatsOnTheLineDiv2()).getAnswer(new int[] {5, 1, -10, 7, 12, 2, 10, 20}, new int[] {3, 4, 2, 7, 1, 4, 3, 4}, 6),"Possible");
            eq(5,(new CatsOnTheLineDiv2()).getAnswer(new int[] {-1000, -999}, new int[] {1000, 1000}, 999), "Possible");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
