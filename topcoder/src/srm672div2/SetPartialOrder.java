package srm672div2;// BEGIN CUT HERE
// PROBLEM STATEMENT
// In math, we sometimes define a partial order on some objects.
/*
In this problem we will take a look at one possible way how to define a partial order on sets of integers.

Consider two sets of integers: X and Y.
These two sets can be related to each other in four possible ways:


X is equal to Y if each element of X is also an element of Y and vice versa.
X is less than Y if X is not equal to Y (see previous item) and each element of X is also an element of Y.
X is greater than Y if Y is less than X.
In all other cases X and Y are incomparable.


In other words:
X is less than Y if and only if X is a proper subset of Y.
Two sets are incomparable if neither is a subset of the other.

You are given two int[]s a and b.
The elements of a form the set X.
The elements of b form the set Y.
Compare X to Y and return the correct one of the following four strings: "EQUAL", "LESS", "GREATER", or "INCOMPARABLE".

(The string "LESS" means that X is less than Y, the string "GREATER" means that X is greater than Y.
Quotes are for clarity only.
Note that the return value is case-sensitive.)

DEFINITION
Class:SetPartialOrder
Method:compareSets
Parameters:int[], int[]
Returns:String
Method signature:String compareSets(int[] a, int[] b)


CONSTRAINTS
-Each of arrays a and b will have length between 1 and 50, inclusive.
-Each element of arrays a and b will be between 1 and 100, inclusive.
-In each of arrays a and b all elements are distinct.


EXAMPLES

0)
{1, 2, 3, 5, 8}
{8, 5, 1, 3, 2}

Returns: "EQUAL"

The order of elements in a and b does not matter. The two sets X and Y are equal.

1)
{2, 3, 5, 7}
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

Returns: "LESS"

Each number that occurs in a does also occur in b.

2)
{2, 4, 6, 8, 10, 12, 14, 16}
{2, 4, 8, 16}

Returns: "GREATER"



3)
{42, 23, 17}
{15, 23, 31}

Returns: "INCOMPARABLE"


*/
// END CUT HERE
/**
 * TESTED
 */
import java.util.*;
public class SetPartialOrder {
    public String compareSets(int[] a, int[] b) {
        Set<Integer> as = toSet(a);
        Set<Integer> bs = toSet(b);
        as.removeAll(bs);
        if(as.size() == 0) {
            if(a.length == b.length) {
                return "EQUAL";
            } else {
                return "LESS";
            }
        }
        as = toSet(a);
        bs.removeAll(as);
        if(bs.size() == 0) {
            return "GREATER";
        }
        return "INCOMPARABLE";
    }

    private Set<Integer> toSet(int[] a) {
        Set<Integer> result = new HashSet<>();
        for (Integer integer : a) {
            result.add(integer);
        }
        return result;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SetPartialOrder()).compareSets(new int[] {1, 2, 3, 5, 8}, new int[] {8, 5, 1, 3, 2}),"EQUAL");
            eq(1,(new SetPartialOrder()).compareSets(new int[] {2, 3, 5, 7}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),"LESS");
            eq(2,(new SetPartialOrder()).compareSets(new int[] {2, 4, 6, 8, 10, 12, 14, 16}, new int[] {2, 4, 8, 16}),"GREATER");
            eq(3,(new SetPartialOrder()).compareSets(new int[] {42, 23, 17}, new int[] {15, 23, 31}),"INCOMPARABLE");
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
