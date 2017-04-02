package srm145div1;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
You have a certain amount of money to give out as a bonus to employees.  The trouble is, who do you pick to receive what bonus?  You decide to assign a number of points to each employee, which corresponds to how much they helped the company in the last year.  You are given an int[] points, where each element contains the points earned by the corresponding employee (i.e. points[0] is the number of points awarded to employee 0).  Using this, you are to calculate the bonuses as follows:



- First, add up all the points, this is the pool of total points awarded.
- Each employee gets a percentage of the bonus money, equal to the percentage of the point pool that the employee got.
- Employees can only receive whole percentage amounts, so if an employee's cut of the bonus has a fractional percentage, truncate it.
- There may be some percentage of bonus left over (because of the fractional truncation).  If n% of the bonus is left over, give the top n employees 1% of the bonus.  There will be no more bonus left after this.  If two or more employees with the same number of points qualify for this "extra" bonus, but not enough bonus is left to give them all an extra 1%, give it to the employees that come first in points.



The return value should be a int[], one element per employee in the order they were passed in.  Each element should be the percent of the bonus that the employee gets.


DEFINITION
Class:Bonuses
Method:getDivision
Parameters:int[]
Returns:int[]
Method signature:int[] getDivision(int[] points)


CONSTRAINTS
-points will have between 1 and 50 elements, inclusive.
-Each element of points will be between 1 and 500, inclusive.


EXAMPLES

0)
{1,2,3,4,5}

Returns: { 6,  13,  20,  27,  34 }

The total points in the point pool is 1+2+3+4+5 = 15.
Employee 1 gets 1/15 of the total pool, or 6.66667%, Employee 2 gets 13.33333%, Employee 3 gets 20% (exactly), Employee 4 gets 26.66667%, and Employee 5 gets 33.33333%.  After truncating, the percentages look like:
{6,13,20,26,33}
Adding up all the fractional percentages, we see there is 2% in extra bonuses, which go to the top two scorers.  These are the employees who received 4 and 5 points.

1)
{5,5,5,5,5,5}

Returns: { 17,  17,  17,  17,  16,  16 }

The pool of points is 30.  Each employee got 1/6 of the total pool, which translates to 16.66667%.  Truncating for all employees, we are left with 4% in extra bonuses.  Because everyone got the same number of points, the extra 1% bonuses are assigned to the four that come first in the array.

2)
{485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
 255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470}

Returns: { 8,  6,  4,  2,  8,  5,  5,  3,  1,  4,  5,  4,  6,  3,  5,  4,  1,  8,  1,  6,  3,  8 }

*/
// END CUT HERE
import java.util.*;
//TESTED
public class Bonuses {
    public int[] getDivision(int[] points) {
            int[] res = new int[points.length];
            int sum = 0;
            for (int point : points) {
                sum+=point;
            }
            List<P> ps = new ArrayList<P>();
            for (int i = 0; i < points.length; i++) {
                int point = points[i];
                ps.add(new P(i, point));
                res[i] = (100*point)/sum;
            }
            int resSum = 0;
            for (int i = 0; i < res.length; i++) {
                int re = res[i];
                resSum+=re;
            }
            int n = 100-resSum;
            Collections.sort(ps);
            for(int i = 0; i < n; i++) {
                P p = ps.get(i);
                res[p.num]++;
            }
            return res;
        }

        private class P implements Comparable<P> {
            int num;
            int point;

            private P(int num, int point) {
                this.num = num;
                this.point = point;
            }

            public int compareTo(P o) {
                return point > o.point ? -1 : (point == o.point ? (num > o.num ? 1 : -1) : 1);
            }
        }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Bonuses()).getDivision(new int[] {1,2,3,4,5}),new int[] { 6,  13,  20,  27,  34 });
            eq(1,(new Bonuses()).getDivision(new int[] {5,5,5,5,5,5}),new int[] { 17,  17,  17,  17,  16,  16 });
            eq(2,(new Bonuses()).getDivision(new int[] {485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
                255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470}),new int[] { 8,  6,  4,  2,  8,  5,  5,  3,  1,  4,  5,  4,  6,  3,  5,  4,  1,  8,  1,  6,  3,  8 });
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
