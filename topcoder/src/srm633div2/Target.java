package srm633div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Here at [topcoder], we call a contestant a "target" if their rating is 3000 or more.
In the arena, the targets have a red icon with a small target on it.
Do you want to become a target as well?
Sure you do.
But before you get there, let's start with something easier: drawing a target.



The target you need to draw consists of nested squares.
The innermost square is just a single '#' character.
The larger squares use alternatingly the character ' ' (space) and the character '#'.
Here is an example in which the side of the largest square is n = 5:




#####
#   #
# # #
#   #
#####



And here is an example for n = 9:



#########
#       #
# ##### #
# #   # #
# # # # #
# #   # #
# ##### #
#       #
#########




You will be given an int n.
Your method must return a String[] which contains a drawing of the target with side n.
More precisely, each element of the returned String[] must be one row of the drawing, in order.
Therefore, the returned String[] will consist of n elements, each with n characters.
(See the examples below for clarification.)



The value of n will be such that a target like the ones above can be drawn: 5, 9, 13, and so on.
Formally, n will be of the form 4k+1, where k is a positive integer.

DEFINITION
Class:Target
Method:draw
Parameters:int
Returns:String[]
Method signature:String[] draw(int n)


CONSTRAINTS
-n will be between 5 and 49, inclusive.
-n mod 4 will be 1.


EXAMPLES

0)
5

Returns: {"#####", "#   #", "# # #", "#   #", "#####" }



1)
9

Returns: {"#########", "#       #", "# ##### #", "# #   # #", "# # # # #", "# #   # #", "# ##### #", "#       #", "#########" }



2)
13

Returns: {"#############", "#           #", "# ######### #", "# #       # #", "# # ##### # #", "# # #   # # #", "# # # # # # #", "# # #   # # #", "# # ##### # #", "# #       # #", "# ######### #", "#           #", "#############" }



3)
17

Returns: {"#################", "#               #", "# ############# #", "# #           # #", "# # ######### # #", "# # #       # # #", "# # # ##### # # #", "# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #", "# # # ##### # # #", "# # #       # # #", "# # ######### # #", "# #           # #", "# ############# #", "#               #", "#################" }



*/
// END CUT HERE
import java.util.*;
//TESTED
public class Target {
    private int xCenter = 0;
    private int yCenter = 0;

    public String[] draw(int n) {
        xCenter = (n - 1) / 2;
        yCenter = (n - 1) / 2;
        char[][] result = new char[n][n];
        for (int i = 0; i < result.length; i++) {
            char[] chars = result[i];
            for (int j = 0; j < chars.length; j++) {
                chars[j] = ' ';
            }
        }
        int count = (n - 1) / 4 + 1;
        for(int i = 0; i < count; i++) {
            if(i == 0) {
                printX(0, 0, result);
            } else {
                for(int j = -2 * i; j <= 2 * i; j++) {
                    printX(j, 2 * i, result);
                    printX(j, -2 * i, result);
                    printX(2 * i, j, result);
                    printX(-2 * i, j, result);
                }
            }
        }
        String[] res = new String[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = new String(result[i]);
        }
        return res;
    }

    private void printX(int x, int y, char[][] result) {
        result[xCenter + x][yCenter + y] = '#';
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Target()).draw(5),new String[] {"#####", "#   #", "# # #", "#   #", "#####" });
            eq(1,(new Target()).draw(9),new String[] {"#########", "#       #", "# ##### #", "# #   # #", "# # # # #", "# #   # #", "# ##### #", "#       #", "#########" });
            eq(2,(new Target()).draw(13),new String[] {"#############", "#           #", "# ######### #", "# #       # #", "# # ##### # #", "# # #   # # #", "# # # # # # #", "# # #   # # #", "# # ##### # #", "# #       # #", "# ######### #", "#           #", "#############" });
            eq(3,(new Target()).draw(17),new String[] {"#################", "#               #", "# ############# #", "# #           # #", "# # ######### # #", "# # #       # # #", "# # # ##### # # #", "# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #", "# # # ##### # # #", "# # #       # # #", "# # ######### # #", "# #           # #", "# ############# #", "#               #", "#################" });
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
