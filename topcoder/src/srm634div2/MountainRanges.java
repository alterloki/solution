package srm634div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Tom is in charge of a tourist agency.
He has a lovely picture of the local mountain range.
He would like to sell it to the tourists but first he needs to know how many peaks are visible in the picture.



The mountain range in the picture can be seen as a sequence of heights.
You are given these heights as a int[] height.
An element of height is called a peak if its value is strictly greater than each of the values of adjacent elements.
Compute and return the number of peaks in the given mountain range.



DEFINITION
Class:MountainRanges
Method:countPeaks
Parameters:int[]
Returns:int
Method signature:int countPeaks(int[] heights)


CONSTRAINTS
-heights will contain between 1 and 50 elements, inclusive.
-Each element of heights will be between 1 and 100, inclusive.


EXAMPLES

0)
{5, 6, 2, 4}

Returns: 2

Element 1 (0-based index) is a peak.
Its height is 6, which is strictly greater than each of its neighbors' heights (5 and 2). 
Element 3 is also a peak since its height is 4 and that is strictly greater than its neighbor's height (which is 2).

1)
{1, 1, 1, 1, 1, 1, 1}

Returns: 0

This is a very flat mountain with no peaks.

2)
{2, 1}

Returns: 1

Element 0 is a peak.

3)
{2,5,3,7,2,8,1,3,1}

Returns: 4

The peaks here are the elements with 0-based indices 1, 3, 5, and 7. Their heights are 5, 7, 8, and 3, respectively.

4)
{1}

Returns: 1

Element 0 is a peak. Even though it has no neighbors, the condition from the problem statement is still satisfied.

5)
{1,2,3,4,4,3,2,1}

Returns: 0

According to our definition there is no peak in this mountain range.

*/
// END CUT HERE
import java.util.*;
//TESTED
public class MountainRanges {
    public int countPeaks(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            boolean left = true;
            if(i > 0) {
                left = heights[i] > heights[i - 1];
            }
            boolean right = true;
            if(i < heights.length - 1) {
                right = heights[i] > heights[i + 1];
            }
            if(left && right) {
                res++;
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new MountainRanges()).countPeaks(new int[] {5, 6, 2, 4}),2);
            eq(1,(new MountainRanges()).countPeaks(new int[] {1, 1, 1, 1, 1, 1, 1}),0);
            eq(2,(new MountainRanges()).countPeaks(new int[] {2, 1}),1);
            eq(3,(new MountainRanges()).countPeaks(new int[] {2,5,3,7,2,8,1,3,1}),4);
            eq(4,(new MountainRanges()).countPeaks(new int[] {1}),1);
            eq(5,(new MountainRanges()).countPeaks(new int[] {1,2,3,4,4,3,2,1}),0);
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
