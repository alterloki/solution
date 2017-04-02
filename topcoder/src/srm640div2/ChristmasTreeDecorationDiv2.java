package srm640div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Christmas is just around the corner, and Alice just decorated her Christmas tree.
There are N stars and N-1 ribbons on the tree.
Each ribbon connects two of the stars in such a way that all stars and ribbons hold together.
(In other words, the stars and ribbons are the vertices and edges of a tree.)



The stars are numbered 1 through N.
Additionally, each star has some color.
You are given the colors of stars as a int[] col with N elements.
For each i, col[i] is the color of star i+1.
(Different integers represent different colors.)



You are also given a description of the ribbons: two int[]s x and y with N-1 elements each.
For each i, there is a ribbon that connects the stars with numbers x[i] and y[i].



According to Alice, a ribbon that connects two stars with different colors is beautiful, while a ribbon that connects two same-colored stars is not.
Compute and return the number of beautiful ribbons in Alice's tree.


DEFINITION
Class:ChristmasTreeDecorationDiv2
Method:solve
Parameters:int[], int[], int[]
Returns:int
Method signature:int solve(int[] col, int[] x, int[] y)


CONSTRAINTS
-N will be between 2 and 50, inclusive.
-The number of elements in col will be exactly N.
-The number of elements in x will be exactly N - 1.
-The number of elements in y will be the same as the number of elements in x.
-All elements of x and y will be between 1 and N, inclusive.
-For each i, the numbers x[i] and y[i] will be different.
-The graph formed by the N-1 ribbons will be connected.


EXAMPLES

0)
{1,2,3,3}
{1,2,3}
{2,3,4}

Returns: 2

There are two beautiful ribbons: the one that connects stars 1 and 2, and the one that connects stars 2 and 3.
The other ribbon is not beautiful because stars 3 and 4 have the same color.

1)
{1,3,5}
{1,3}
{2,2}

Returns: 2



2)
{1,1,3,3}
{1,3,2}
{2,1,4}

Returns: 2



3)
{5,5,5,5}
{1,2,3}
{2,3,4}

Returns: 0



4)
{9,1,1}
{3,2}
{2,1}

Returns: 1



*/
// END CUT HERE
import java.util.*;
//TESTED
public class ChristmasTreeDecorationDiv2 {
    public int solve(int[] col, int[] x, int[] y) {
        int res = 0;
        for (int i = 0; i < x.length; i++) {
            if(col[x[i] - 1] != col[y[i] - 1]) {
                res++;
            }

        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ChristmasTreeDecorationDiv2()).solve(new int[] {1,2,3,3}, new int[] {1,2,3}, new int[] {2,3,4}),2);
            eq(1,(new ChristmasTreeDecorationDiv2()).solve(new int[] {1,3,5}, new int[] {1,3}, new int[] {2,2}),2);
            eq(2,(new ChristmasTreeDecorationDiv2()).solve(new int[] {1,1,3,3}, new int[] {1,3,2}, new int[] {2,1,4}),2);
            eq(3,(new ChristmasTreeDecorationDiv2()).solve(new int[] {5,5,5,5}, new int[] {1,2,3}, new int[] {2,3,4}),0);
            eq(4,(new ChristmasTreeDecorationDiv2()).solve(new int[] {9,1,1}, new int[] {3,2}, new int[] {2,1}),1);
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
