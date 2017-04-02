package srm639div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Little Petya likes puzzles a lot.
Recently he has received one as a gift from his mother.
The puzzle has the form of a rectangular sheet of paper that is divided into N rows by M columns of unit square cells.
Rows are numbered 0 through N-1 from top to bottom, and columns 0 through M-1 from left to right.
Each cell is colored either black or white.
You are given a description of the paper, the exact format is specified at the end of this problem statement.


The goal of the puzzle is to fold the paper.
This has to be done in a sequence of turns.
In each turn, Petya has to fold the paper according to the rules below.
He can end the process after any number of turns (including zero), even if there are still valid ways to fold the paper.


In each turn, Petya must follow these steps:
To start folding, he must choose a line that is parallel to one of the sides of the paper and passes between two rows/columns of cells.
He can then take the smaller part of the paper and fold it on top of the larger part.
(If the line divides the current paper in half, he can fold either half on top of the other.)
There is one additional restriction:
Petya may only perform the fold if all cells of the part that is being folded land on equally-colored cells of the part that remains in place.


For example, consider the following paper (with 0 and 1 representing white and black):

10010101
11110100
00000000
01101110



Here, Petya could choose the vertical line that goes between the two leftmost columns and the rest of the paper.
Note that this is a valid choice: as he makes the fold, the cells from the leftmost two columns will all match their counterparts in the right part of the
paper.
This is how the paper looks like after the fold (with periods representing empty spaces):

..010101
..110100
..000000
..101110



Clearly, even after multiple folds the paper will always look like a subrectangle of the original paper.
Two states of the game are considered the same if that rectangle has the same dimensions and the same offset with respect to the original top left corner of
the paper.
(Note that folding order does not matter. Two different sequences of folding may produce the same final state.)


You are given a description of the original state of the paper as a String[] paper. Here N is the number of elements in paper and M is the length of its each element. For each i and j, the character paper[i][j] is either '0' (meaning that the cell (i,j) is white) or '1' (the cell is black).
Compute and return the number of possible final states of the game.

DEFINITION
Class:BoardFoldingDiv2
Method:howMany
Parameters:String[]
Returns:int
Method signature:int howMany(String[] paper)


CONSTRAINTS
-paper will contain between 1 and 50 elements, inclusive.
-Each element of paper will contain between 1 and 50 elements, inclusive.
-All elements of paper will have the same length.
-paper will contain only characters '0' and '1'.


EXAMPLES

0)
{"10",
 "11"}

Returns: 1

There is no valid way to fold this paper, so there is just one possible outcome.

1)
{"1111111",
 "1111111"}

Returns: 84

We can fold it into any of the 84 possible subrectangles of the original rectangle.

2)
{"0110",
 "1001",
 "1001",
 "0110"}

Returns: 9



3)
{"0",
 "0",
 "0",
 "1",
 "0",
 "0"}

Returns: 6



4)
{"000",
 "010",
 "000"}

Returns: 1



*/
// END CUT HERE
import java.util.*;
//TESTED
public class BoardFoldingDiv2 {
    public int howMany(String[] paper) {
        char[][] p = new char[paper.length][];
        for (int i = 0; i < paper.length; i++) {
            p[i] = paper[i].toCharArray();
        }
        int vertical = verticalCount(p);
        int horizontal = verticalCount(rotate(p));
        return vertical * horizontal;
    }

    private int verticalCount(char[][] paper) {
        boolean[] top1 = topCount(paper);
        boolean[] top2 = topCount(flipVertical(paper));
        int count = 0;
        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j + i < paper.length; j++) {
                if(top1[i] && top2[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private char[][] flipVertical(char[][] paper) {
        char[][] newPaper = new char[paper.length][paper[0].length];
        for (int i = 0; i < newPaper.length; i++) {
            for (int j = 0; j < newPaper[0].length; j++) {
                newPaper[i][j] = paper[newPaper.length - i - 1][j];
            }
        }
        return newPaper;
    }

    private boolean[] topCount(char[][] paper) {
        boolean[] result = new boolean[paper.length];
        result[0] = true;
        for(int i = 0; i < paper.length; i++) {
            if(result[i]) {
                for(int j = 1; i + j + j <= paper.length; j++) {
                    boolean canBe = true;
                    for(int k = 0; k < j; k++) {
                        for(int t = 0; t < paper[0].length; t++) {
                            if(paper[i + k][t] != paper[i + j + j - k - 1][t]) {
                                canBe = false;
                                break;
                            }
                        }
                    }
                    if (canBe) {
                        result[i + j] = true;
                    }
                }
            }
        }
        return result;
    }

    private char[][] rotate(char[][] paper) {
        int oldH = paper.length;
        int oldW = paper[0].length;
        char[][] newPaper = new char[oldW][oldH];
        for (int i = 0; i < newPaper.length; i++) {
            for (int j = 0; j < newPaper[i].length; j++) {
                newPaper[i][j] = paper[j][i];
            }
        }
        return newPaper;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BoardFoldingDiv2()).howMany(new String[] {"10",
                "11"}),1);
            eq(1,(new BoardFoldingDiv2()).howMany(new String[] {"1111111",
                "1111111"}),84);
            eq(2,(new BoardFoldingDiv2()).howMany(new String[] {"0110",
                "1001",
                "1001",
                "0110"}),9);
            eq(3,(new BoardFoldingDiv2()).howMany(new String[] {"0",
                "0",
                "0",
                "1",
                "0",
                "0"}),6);
            eq(4,(new BoardFoldingDiv2()).howMany(new String[] {"000",
                "010",
                "000"}),1);
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
