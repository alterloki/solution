package srm636div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Limak has found a large field with some piles of stones.

Limak likes perfection. It would make him happy if every pile had the same number of stones. He is now going to move some stones between the piles to make them all equal.

However, there is a catch.
Limak's perfectionism does not allow him to carry just one stone at a time.
As he has two hands, he must always carry exactly two stones: one in each hand.
Thus, he can only make one type of an action: pick up two stones from one of the piles and carry both of them to some other pile. He is not allowed to remove a pile completely. Therefore, he cannot pick up stones from a pile that currently contains fewer than 3 stones.

You are given a int[] stones.
Each element of stones is the initial number of stones in one of the piles.
Compute and return the smallest number of actions Limak has to perform in order to make all piles equal.
If it is impossible to make all piles equal using the allowed type of actions, return -1 instead.

DEFINITION
Class:GameOfStones
Method:count
Parameters:int[]
Returns:int
Method signature:int count(int[] stones)


CONSTRAINTS
-stones will contain between 1 and 100 elements, inclusive. 
-Each element in stones will be between 1 and 100, inclusive.


EXAMPLES

0)
{7, 15, 9, 5}

Returns: 3

There are four piles of stones.
There are 7 stones in pile number 0, 15 stones in pile number 1, 9 stones in pile number 2, and 5 stones in pile number 3.
One optimal solution looks as follows:
First, Limak will move a pair of stones from pile 1 to pile 0.
Afterwards, Limak will twice move a pair of stones from pile 1 to pile 3.
After these 3 actions, each pile contains exactly 9 stones.

1)
{10, 16}

Returns: -1

It can be proven that Limak can't make these two piles equal.

2)
{2, 8, 4}

Returns: -1



3)
{17}

Returns: 0

Limak doesn't need to perform any actions. There is only one pile and it means that all piles already have the same size.

4)
{10, 15, 20, 12, 1, 20}

Returns: -1



*/
// END CUT HERE
import java.util.*;
//TESTED
public class GameOfStones {
    public int count(int[] stones) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        if(sum % stones.length > 0) {
            return -1;
        }
        int resultCount = sum / stones.length;
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            int delta = Math.abs(stone - resultCount);
            if(delta % 2 > 0) {
                return -1;
            }
            res += delta;
        }
        return res / 4;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new GameOfStones()).count(new int[] {7, 15, 9, 5}),3);
            eq(1,(new GameOfStones()).count(new int[] {10, 16}),-1);
            eq(2,(new GameOfStones()).count(new int[] {2, 8, 4}),-1);
            eq(3,(new GameOfStones()).count(new int[] {17}),0);
            eq(4,(new GameOfStones()).count(new int[] {10, 15, 20, 12, 1, 20}),-1);
            eq(5,(new GameOfStones()).count(new int[] {17, 1, 27, 29, 13, 1, 27, 3, 19, 3, 25, 1, 11, 9, 7, 17, 31, 25, 5, 11, 31, 9, 15, 3, 3, 3, 11, 11, 1, 41, 5, 95, 7, 3, 41, 31, 7, 13, 15, 5, 17, 3, 9, 3, 11, 27, 1, 23, 15, 5, 43, 11, 17, 7, 1, 3, 13, 69, 3, 43, 21, 1, 25, 1, 3, 11, 5, 43, 13, 7, 15, 1, 1, 55, 37, 9, 5, 7, 21, 3, 23, 15, 1, 9, 3, 35, 13, 17, 7, 17, 27, 5, 9, 19, 13, 1, 1, 1, 29}), 277);
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
