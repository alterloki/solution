package srm637div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Cat Snuke is playing the Path Game.

The Path Game is played on a rectangular grid of square cells.
The grid has 2 rows and some positive number of columns.
Each cell is either black or white.

A left-to-right path in the grid is a sequence of white cells such that the first cell in the sequence is in the leftmost column, the last cell in the sequence is in the rightmost column, and each pair of consecutive cells shares a common side.

The initial coloring of the grid is such that there is at least one left-to-right path.
You are given this initial coloring as a String[] board with two elements.
For each i and j, board[i][j] is either '#' (representing a black cell) or '.' (representing a white cell).

Snuke may color some of the white cells black.
After he does so, there must still be at least one left-to-right path left on the board.
The goal of the game is to color as many cells black as possible.
Compute and return the largest number of cells Snuke can color black.
(Note that the cells that are already black do not count.)

DEFINITION
Class:PathGameDiv2
Method:calc
Parameters:String[]
Returns:int
Method signature:int calc(String[] board)


CONSTRAINTS
-board will contain 2 elements.
-Each element in board will contain between 1 and 50 characters, inclusive.
-All elements in board will have the same length.
-Each character in board will be '#' or '.'.
-The grid described by board will contain a left-to-right path.


EXAMPLES

0)
{"#...."
,"...#."}

Returns: 2

Snuke can color at most two white cells black.
One possible final state of the board looks as follows:

#....
..###


1)
{"#"
,"."}

Returns: 0

Snuke can't color any cells.

2)
{"."
,"."}

Returns: 1



3)
{"....#.##.....#..........."
,"..#......#.......#..#...."}

Returns: 13



*/
// END CUT HERE

import java.util.*;
//TESTED
public class PathGameDiv2 {
    public int calc(String[] board) {
        int res1 = alg(board, new int[]{0, 1});
        int res2 = alg(board, new int[]{1, 0});
        return Math.max(res1, res2);
    }

    private int alg(String[] board, int[] js) {
        int res = 0;
        char[][] columns = new char[board[0].length()][];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new char[2];
            columns[i][0] = board[0].charAt(i);
            columns[i][1] = board[1].charAt(i);
        }
        for (int i = 0; i < columns.length; i++) {
            char[] column = columns[i];
            for (int j: js) {
                if (column[j] == '.') {
                    column[j] = '#';
                    if (havePath(columns)) {
                        res++;
                    } else {
                        column[j] = '.';
                    }
                }
            }
        }
        return res;
    }

    private boolean havePath(char[][] columns) {
        if(columns[0][0] == '#' && columns[0][1] == '#') {
            return false;
        }
        for (int i = 0; i < columns.length - 1; i++) {
            boolean upWhile = columns[i][0] == '.' && columns[i + 1][0] == '.';
            boolean downWhite = columns[i][1] == '.' && columns[i + 1][1] == '.';
            if(!upWhile && !downWhite) {
                return false;
            }
        }
        return true;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new PathGameDiv2()).calc(new String[]{"#...."
                    , "...#."}), 2);
            eq(1, (new PathGameDiv2()).calc(new String[]{"#"
                    , "."}), 0);
            eq(2, (new PathGameDiv2()).calc(new String[]{"."
                    , "."}), 1);
            eq(3, (new PathGameDiv2()).calc(new String[]{"....#.##.....#..........."
                    , "..#......#.......#..#...."}), 13);
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
