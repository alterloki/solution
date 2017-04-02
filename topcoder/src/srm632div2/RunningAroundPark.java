package srm632div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Alice went jogging around the park yesterday.
There is a circular track around the park, and Alice's house is right next to the track.
Alice ran in the clockwise direction.
She both started and ended her run at her house.
In other words, she completed some positive number of full laps.



There are N trees along the track.
The trees are numbered 1 through N in the order in which Alice encounters them when running a single lap.
You are given the int N.



Alice remembers some trees she saw during her run.
She remembers them in the order in which she encountered them.
You are given this information as a int[] d.



For example, d={6,6,1} has the following meaning:

Alice started running.
After some time she encountered the tree number 6.
After some more time she encountered the tree number 6.
Even later she encountered the tree number 1.




Compute and return the smallest possible number of laps Alice completed.


DEFINITION
Class:RunningAroundPark
Method:numberOfLap
Parameters:int, int[]
Returns:int
Method signature:int numberOfLap(int N, int[] d)


CONSTRAINTS
-N will be between 2 and 50, inclusive.
-d will contain between 1 and 50 elements.
-Each element of d will be between 1 and N, inclusive.


EXAMPLES

0)
3
{1,2,3}

Returns: 1

It is possible that Alice ran just a single lap and remembered all the trees she saw.

1)
24
{6,6}

Returns: 2

Alice ran past the tree number 6 at least twice, so there must have been at least two laps.

2)
3
{3,2,1}

Returns: 3



3)
50
{1,3,5,7,9,2,4,6,8,10}

Returns: 2



*/
// END CUT HERE
import java.util.*;
//TESTED
public class RunningAroundPark {
    public int numberOfLap(int N, int[] d) {
        int res = 0;
        int prev = N;
        for (int i = 0; i < d.length; i++) {
            int currentTree = d[i];
            if(currentTree <= prev) {
                res++;
            }
            prev = currentTree;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new RunningAroundPark()).numberOfLap(3, new int[] {1,2,3}),1);
            eq(1,(new RunningAroundPark()).numberOfLap(24, new int[] {6,6}),2);
            eq(2,(new RunningAroundPark()).numberOfLap(3, new int[] {3,2,1}),3);
            eq(3,(new RunningAroundPark()).numberOfLap(50, new int[] {1,3,5,7,9,2,4,6,8,10}),2);
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
