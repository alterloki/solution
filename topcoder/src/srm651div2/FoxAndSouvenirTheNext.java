package srm651div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Fox Ciel just returned home from her trip to New Fox City.
She has brought a bunch of souvenirs.
You are given their values in a int[] value.


Now she wants to give each souvenir either to her mother or to her father.
She would like to divide the souvenirs in a fair way.
More precisely:

The total number of souvenirs given to her mother must be the same as the total number of souvenirs given to her father.
At the same time, the total value of souvenirs given to her mother must be the same as the total value of souvenirs given to her father.



Return "Possible" if she can reach her goal, and "Impossible" otherwise.

DEFINITION
Class:FoxAndSouvenirTheNext
Method:ableToSplit
Parameters:int[]
Returns:String
Method signature:String ableToSplit(int[] value)


CONSTRAINTS
-value will contain between 1 and 50 elements, inclusive.
-Each element in value will be between 1 and 50, inclusive.


EXAMPLES

0)
{1,2,3,4}

Returns: "Possible"

One valid solution is to give the souvenirs with values 1 and 4 to her mother and the other two to her father. Each parent receives two souvenirs, and as 1+4 = 2+3, the total value is also the same for both parents.

1)
{1,1,1,3}

Returns: "Impossible"

There is no valid solution. Note that {1,1,1} and {3} is not a valid way to split the souvenirs: even though the total value is the same, the number of souvenirs is not.

2)
{1,1,2,3,5,8}

Returns: "Possible"

We have 1+1+8 = 2+3+5.

3)
{2,3,5,7,11,13}

Returns: "Impossible"

The sum of values is an odd number, so it is impossible.

4)
{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48}

Returns: "Possible"



5)
{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}

Returns: "Impossible"



*/
// END CUT HERE
import java.util.*;
//TESTED
public class FoxAndSouvenirTheNext {

    public static final String IMPOSSIBLE = "Impossible";
    public static final String POSSIBLE = "Possible";

    public String ableToSplit(int[] value) {
        if(value.length % 2 > 0) {
            return IMPOSSIBLE;
        }
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
        }
        if(sum % 2 > 0) {
            return IMPOSSIBLE;
        }
        boolean[][] parts = new boolean[51][3000];
        parts[0][0] = true;
        for(int i = 0; i < value.length; i++) {
            for(int j = 0; j < 50; j++) {
                for(int k = 0; k < 2500; k++) {
                    if(parts[j][k]) {
                        parts[j + 1][k + value[i]] = true;
                    }
                }
            }
        }
        return parts[value.length/2][sum/2] ? POSSIBLE : IMPOSSIBLE;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {1,2,3,4}),"Possible");
            eq(1,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {1,1,1,3}),"Impossible");
            eq(2,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {1,1,2,3,5,8}),"Possible");
            eq(3,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {2,3,5,7,11,13}),"Impossible");
            eq(4,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48}),"Possible");
            eq(5,(new FoxAndSouvenirTheNext()).ableToSplit(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}),"Impossible");
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
