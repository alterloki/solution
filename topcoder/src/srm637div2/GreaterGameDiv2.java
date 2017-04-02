package srm637div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Cat Snuke and wolf Sothe are playing the Greater Game.
The game is played with cards.
Each card has a number written on it.
There are 2N cards.
The numbers on the cards are the integers between 1 and 2N, inclusive.

At the beginning of the game, each player gets N of the cards and chooses the order in which he wants to play them.
The game then consists of N turns.
In each turn, both players play one of their cards simultaneously.
The player who revealed the card with the larger number gets a point.

You are given two int[]s: snuke and sothe.
The elements of snuke are the numbers on the cards Snuke is going to play, in order.
Similarly, the elements of sothe are the numbers on the cards Sothe is going to play, in order.
Compute and return the number of points Snuke will have at the end of the game.

DEFINITION
Class:GreaterGameDiv2
Method:calc
Parameters:int[], int[]
Returns:int
Method signature:int calc(int[] snuke, int[] sothe)


CONSTRAINTS
-N will be between 1 and 50, inclusive.
-snuke and sothe will contain exactly N elements each.
-Each integer in snuke and sothe will be between 1 and 2N, inclusive.
-The integers in snuke and sothe will be distinct.


EXAMPLES

0)
{1,3}
{4,2}

Returns: 1

Snuke loses the first round because 1 is less than 4. Snuke then wins the second round because 3 is greater than 2.

1)
{1,3,5,7,9}
{2,4,6,8,10}

Returns: 0



2)
{2}
{1}

Returns: 1



3)
{3,5,9,16,14,20,15,17,13,2}
{6,18,1,8,7,10,11,19,12,4}

Returns: 6



*/
// END CUT HERE
import java.util.*;
//TESTED
public class GreaterGameDiv2 {
    public int calc(int[] snuke, int[] sothe) {
        int res = 0;
        for (int i = 0; i < snuke.length; i++) {
            int sn = snuke[i];
            int so = sothe[i];
            if(sn > so) {
                res++;
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new GreaterGameDiv2()).calc(new int[] {1,3}, new int[] {4,2}),1);
            eq(1,(new GreaterGameDiv2()).calc(new int[] {1,3,5,7,9}, new int[] {2,4,6,8,10}),0);
            eq(2,(new GreaterGameDiv2()).calc(new int[] {2}, new int[] {1}),1);
            eq(3,(new GreaterGameDiv2()).calc(new int[] {3,5,9,16,14,20,15,17,13,2}, new int[] {6,18,1,8,7,10,11,19,12,4}),6);
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
