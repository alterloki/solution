package srm207div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Harry is playing magical chess. In this version of the game, all pieces move the same way as in regular chess, but players can cast some magical spells. Unfortunately, Harry's opponent, Joe, has captured all of Harry's pieces except one knight; Joe, on the other hand, still has a queen and a rook. The only chance Harry has to win this game is to cast a spell, "Haste", that will allow Harry's knight to make several moves in a row. You should determine the minimal number of moves the knight needs to capture both the rook and the queen, assuming neither of them moves.  You may capture them in either order - rook first or queen first.

You will be given a String, knight, containing information about the knight. You will also be given a String, queen, and a String, rook, giving you information about Joe's pieces. knight, rook and queen will be formatted as "cr", where c is a character between 'a' and 'h', inclusive, determining the column on the board ('a' is the first column, 'h' is the last), and r is a digit between '1' and '8', inclusive, determining the row (1 is the lowest, 8 is the highest).


DEFINITION
Class:CaptureThemAll
Method:fastKnight
Parameters:String, String, String
Returns:int
Method signature:int fastKnight(String knight, String rook, String queen)


NOTES
-A knight's jump moves him 2 cells along one of the axes, and 1 cell along the other one. In other words, if knight is in the (0,0) now, it can be in (-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1, -2), (-1, 2) or (1, 2) after his move.
-The knight will capture one of Joe's pieces if it ends its move in the cell that the piece occupies.
-The knight cannot jump out of the board.
-A chessboard has 8 rows and 8 columns.


CONSTRAINTS
-knight, rook and queen will all be distinct.
-knight, rook and queen will be formatted as "cr", where c is a lowercase character between 'a' and 'h', inclusive, and r is a digit between '1' and '8', inclusive.


EXAMPLES

0)
"a1"
"b3"
"c5"

Returns: 2

From "a1", the knight can move directly to "b3" and capture the rook.  From there, the knight can move directly to "c5" and capture the queen.

1)
"b1"
"c3"
"a3"

Returns: 3

The rook and the queen are both 1 move away from the knight.  Once the knight captures one of them (it doesn't matter which one), it can return to its starting location, and capture the other piece in one more move.

2)
"a1"
"a2"
"b2"

Returns: 6

The rook and the queen are close, but it takes 6 moves to capture them.

3)
"a5"
"b7"
"e4"

Returns: 3

4)
"h8"
"e2"
"d2"

Returns: 6

*/
// END CUT HERE
//TESTED
import java.util.*;

public class CaptureThemAll {

    public int fastKnight(String knight, String rook, String queen) {
        int minKR = minFromTo(knight, rook);
        int minKQ = minFromTo(knight, queen);
        int minRQ = minFromTo(rook, queen);
        return Math.min(minKR + minRQ, minKQ + minRQ);
    }

    private int minFromTo(String knight, String rook) {
        Queue<String> queue = new LinkedList<>();
        queue.add(knight);
        Map<String, Integer> distance = new HashMap<>();
        distance.put(knight, 0);
        while (queue.size() > 0) {
            String field = queue.remove();
            Integer curDist = distance.get(field);
            char[] ca = field.toCharArray();
            if (checkCA(rook, queue, distance, curDist, ca, 1, 2)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, 2, 1)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, 2, -1)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, 1, -2)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, -2, 1)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, -1, 2)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, -2, -1)) {
                return curDist + 1;
            }
            if (checkCA(rook, queue, distance, curDist, ca, -1, -2)) {
                return curDist + 1;
            }
        }
        return -1000;
    }

    private boolean checkCA(String rook, Queue<String> queue, Map<String, Integer> distance, Integer curDist, char[] ca, int a, int b) {
        char[] ca1 = new char[]{(char) (ca[0] + a), (char) (ca[1] + b)};
        if (inside(ca1)) {
            String s = new String(ca1);
            Integer d = distance.get(s);
            if (d == null) {
                if (s.equals(rook)) {
                    return true;
                }
                distance.put(s, curDist + 1);
                queue.add(s);
            }
        }
        return false;
    }

    private boolean inside(char[] ca) {
        return ca[0] >= 'a' && ca[0] <= 'h' && ca[1] >= '1' && ca[1] <= '8';
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new CaptureThemAll()).fastKnight("a1", "b3", "c5"), 2);
            eq(1, (new CaptureThemAll()).fastKnight("b1", "c3", "a3"), 3);
            eq(2, (new CaptureThemAll()).fastKnight("a1", "a2", "b2"), 6);
            eq(3, (new CaptureThemAll()).fastKnight("a5", "b7", "e4"), 3);
            eq(4, (new CaptureThemAll()).fastKnight("h8", "e2", "d2"), 6);
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
