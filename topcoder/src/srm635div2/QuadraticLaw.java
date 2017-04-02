package srm635div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
"Němec's quadratic law: how many minutes the teacher was late to the lesson, that many minutes squared he'll end the lesson earlier."



In other words, if the teacher is t minutes late (for some non-negative integer t), he should end the lesson t2 minutes early. Of course, this means the teacher can't be too late, because a lesson can't end before even starting. It is, however, possible for the teacher to arrive and end the lesson immediately (in fact, he then only arrives to tell the students that the lesson's cancelled).



You're given a long d. The lesson was supposed to take d minutes. Compute and return the largest non-negative integer t such that the teacher can be t minutes late.


DEFINITION
Class:QuadraticLaw
Method:getTime
Parameters:long
Returns:long
Method signature:long getTime(long d)


CONSTRAINTS
-d will be between 1 and 1,000,000,000,000,000,000, inclusive.


EXAMPLES

0)
1

Returns: 0

The lesson was supposed to take 1 minute. The teacher can only be 0 minutes late, in which case he ends the lesson 0 minutes early (i.e. he arrives and ends the lecture on time).

1)
2

Returns: 1

It's possible for the teacher to be 1 minute late and end the lecture 1 minute early (so there's no lecture at all).

2)
5

Returns: 1



3)
6

Returns: 2



4)
7

Returns: 2



5)
1482

Returns: 38



6)
1000000000000000000

Returns: 999999999



7)
31958809614643170

Returns: 178770270



*/
// END CUT HERE
import java.math.BigDecimal;
import java.util.*;
//TESTED
public class QuadraticLaw {
    public long getTime(long d) {
        long res = (long)Math.sqrt(d);
        while(res + res * res > d) {
            res--;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new QuadraticLaw()).getTime(1L),0L);
            eq(1,(new QuadraticLaw()).getTime(2L),1L);
            eq(2,(new QuadraticLaw()).getTime(5L),1L);
            eq(3,(new QuadraticLaw()).getTime(6L),2L);
            eq(4,(new QuadraticLaw()).getTime(7L),2L);
            eq(5,(new QuadraticLaw()).getTime(1482L),38L);
            eq(6,(new QuadraticLaw()).getTime(1000000000000000000L),999999999L);
            eq(7,(new QuadraticLaw()).getTime(31958809614643170L),178770270L);
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
