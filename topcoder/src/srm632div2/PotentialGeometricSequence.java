// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
We have a sequence of N positive integers: a[0] through a[N-1].
You do not know these integers.
All you know is the number of trailing zeros in their binary representations.
You are given a int[] d with N elements.
For each i, d[i] is the number of trailing zeros in the binary representation of a[i].



For example, suppose that a[0]=40.
In binary, 40 is 101000 which ends in three zeros.
Therefore, d[0] will be 3.



You like geometric sequences.
(See the Notes section for a definition of a geometric sequence.)
You would like to count all non-empty contiguous subsequences of the sequence a[0], a[1], ..., a[N-1] that can be geometric sequences (given the information you have in d).



More precisely:
For each pair (i,j) such that 0 <= i <= j <= N-1, we ask the following question: "Given the values d[i] through d[j], is it possible that the values a[i] through a[j] form a geometric sequence?"



For example, suppose that d = {0,1,2,3,2}.
For i=0 and j=3 the answer is positive: it is possible that the values a[0] through a[3] are {1,2,4,8} which is a geometric sequence.
For i=1 and j=4 the answer is negative: there is no geometric sequence with these numbers of trailing zeros in binary.



Compute and return the number of contiguous subsequences of a[0], a[1], ..., a[N-1] that can be geometric sequences.


DEFINITION
Class:PotentialGeometricSequence
Method:numberOfSubsequences
Parameters:int[]
Returns:int
Method signature:int numberOfSubsequences(int[] d)


NOTES
-A geometric sequence is any sequence g[0], g[1], ..., g[k-1] such that there is a real number q (the quotient) with the property that for each valid i, g[i+1] = g[i]*q. For example, {1,2,4,8} is a geometric sequence with q=2, {7,7,7} is a geometric sequence with q=1, and {18,6,2} is a geometric sequence with q=1/3.


CONSTRAINTS
-N will be between 1 and 50, inclusive.
-d will contain exactly N elements.
-Each element of d will be between 0 and 100, inclusive.


EXAMPLES

0)
{0,1,2}

Returns: 6

One possibility is that a[0]=3, a[1]=6, and a[2]=12. In this case, all contiguous subsequences of this sequence are geometric.

1)
{1,2,4}

Returns: 5

All one-element and two-element subsequences are geometric. The entire sequence cannot be geometric.

2)
{3,2,1,0}

Returns: 10



3)
{1,2,4,8,16}

Returns: 9



4)
{1,3,5,5,5,5,64,4,23,2,3,4,5,4,3}

Returns: 37



*/
// END CUT HERE
import java.util.*;
public class PotentialGeometricSequence {
    public int numberOfSubsequences(int[] d) {
        int res = 0;
        for (int i = 0; i < d.length; i++) {
            int prev = 0;
            for(int j = i; j < d.length; j++) {
                if(j == i) {
                    res++;
                } else if(j - i == 1) {
                    prev = d[j] - d[i];
                    res++;
                } else {
                    if(d[j] - d[j - 1] == prev) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PotentialGeometricSequence()).numberOfSubsequences(new int[] {0,1,2}),6);
            eq(1,(new PotentialGeometricSequence()).numberOfSubsequences(new int[] {1,2,4}),5);
            eq(2,(new PotentialGeometricSequence()).numberOfSubsequences(new int[] {3,2,1,0}),10);
            eq(3,(new PotentialGeometricSequence()).numberOfSubsequences(new int[] {1,2,4,8,16}),9);
            eq(4,(new PotentialGeometricSequence()).numberOfSubsequences(new int[] {1,3,5,5,5,5,64,4,23,2,3,4,5,4,3}),37);
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
