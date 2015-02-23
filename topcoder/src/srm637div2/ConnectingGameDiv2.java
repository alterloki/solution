package srm637div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Cat Snuke and wolf Sothe are playing the Connecting Game.

The Connecting Game is played on a rectangular grid that is divided into unit square cells.
The grid is divided into some regions.
Each cell belongs into exactly one of those regions.
Each region is 4-connected (see Notes for a formal definition).

You are given a String[] board that describes the division of the grid into regions.
Each character in board represents one of the cells.
Cells that are represented by the same character belong into the same region.

Initially, the entire grid is colorless.
The game consists of two steps.
In the first step, Snuke colors some of the regions red.
In the second step, Sothe colors all remaining regions blue.
(Within each region, all cells must have the same color.)
Sothe wins if there is a path (see Notes for a formal definition) of blue cells from the top row to the bottom row.
Otherwise, Snuke wins.

You are given the String[] board.
Compute and return the smallest number of cells Snuke can color red in order to win the game.

(Note that Snuke cannot simply color individual cells, he must color entire regions.
Also note that we are interested in minimizing the total number of cells, not the number of regions Snuke colors.)

DEFINITION
Class:ConnectingGameDiv2
Method:getmin
Parameters:String[]
Returns:int
Method signature:int getmin(String[] board)


NOTES
-A path is a sequence of cells such that each pair of consecutive cells shares a common side.
-A region is 4-connected if for any two cells A and B in that region there is a path that starts with A, ends with B, and only contains cells from that region.


CONSTRAINTS
-board will contain between 1 and 50 elements, inclusive.
-Each element in board will contain between 1 and 50 characters, inclusive.
-All elements in board will have the same length.
-Each character in board will be a letter or a digit ('a'-'z', 'A'-'Z', or '0'-'9').
-Each of the regions in board will be 4-connected.


EXAMPLES

0)
{"AA"
,"BC"}

Returns: 2

If Snuke colors 0 or 1 cells red, he will lose the game. He can win the game by coloring 2 cells red. One possibility is to color the two 'A' cells red.

1)
{"AAB"
,"ACD"
,"CCD"}

Returns: 4

Here, one optimal solution is to color the regions 'B' and 'C' red. There will be 1 + 3 = 4 red cells.

2)
{"iii"
,"iwi"
,"iii"}

Returns: 8



3)
{"rng58"
,"Snuke"
,"Sothe"}

Returns: 6



4)
{"yyAArJqjWTH5","yyEEruYYWTHG","hooEvutpkkb2","OooNgFFF9sbi","RRMNgFL99Vmm","R76XgFF9dVVV","SKnZUPf88Vee"}

Returns: 14



*/
// END CUT HERE
import java.util.*;
//TESTED
public class ConnectingGameDiv2 {

    private class WeightedCoord implements Comparable<WeightedCoord> {

        private WeightedCoord(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(WeightedCoord o) {
            int compare = Integer.compare(o.weight, this.weight);
            if(compare == 0) {
                int cx = Integer.compare(o.x, this.x);
                if(cx == 0) {
                    return Integer.compare(o.y, this.y);
                }
                return cx;
            }
            return compare;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WeightedCoord coord = (WeightedCoord) o;

            if (weight != coord.weight) return false;
            if (x != coord.x) return false;
            if (y != coord.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + weight;
            return result;
        }

        int x;
        int y;
        int weight;
    }

    public int getmin(String[] board) {
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> regSize = new HashMap<>();
        int height = board.length;
        int width = board[0].length();
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            char[] ca = s.toCharArray();
            for (int j = 0; j < ca.length; j++) {
                char c = ca[j];
                Integer count = regSize.get(c);
                if(count == null) {
                    count = 0;
                }
                count++;
                regSize.put(c, count);
            }
        }
        int[][] distance = new int[width][height];
        for (int i = 0; i < distance.length; i++) {
            int[] ints = distance[i];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = Integer.MAX_VALUE;
            }
        }
        SortedSet<WeightedCoord> queue = new TreeSet<>();
        for(int i = 0; i < height; i++) {
            char c = board[i].charAt(0);
            distance[0][i] = regSize.get(c);
            queue.add(new WeightedCoord(0, i, 0));
        }
        while (!queue.isEmpty()) {
            WeightedCoord coord = queue.first();
            queue.remove(coord);
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int nx = coord.x + i;
                    int ny = coord.y + j;
                    if(nx >= 0 && nx < width && ny >= 0 && ny < height && !(i==0&&j==0)) {
                        int delta = board[ny].charAt(nx) == board[coord.y].charAt(coord.x) ? 0 : regSize.get(board[ny].charAt(nx));
                        int nDist = distance[coord.x][coord.y] + delta;
                        if(distance[nx][ny] > nDist) {
                            WeightedCoord oldCoord = new WeightedCoord(nx, ny, distance[nx][ny]);
                            queue.remove(oldCoord);
                            queue.add(new WeightedCoord(nx, ny, nDist));
                            distance[nx][ny] = nDist;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            if(distance[width - 1][i] < res) {
                res = distance[width - 1][i];
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ConnectingGameDiv2()).getmin(new String[] {"AA"
               ,"BC"}),2);
            eq(1,(new ConnectingGameDiv2()).getmin(new String[] {"AAB"
               ,"ACD"
               ,"CCD"}),4);
            eq(2,(new ConnectingGameDiv2()).getmin(new String[] {"iii"
               ,"iwi"
               ,"iii"}),8);
            eq(3,(new ConnectingGameDiv2()).getmin(new String[] {"rng58"
               ,"Snuke"
               ,"Sothe"}),6);
            eq(4,(new ConnectingGameDiv2()).getmin(new String[] {"yyAArJqjWTH5","yyEEruYYWTHG","hooEvutpkkb2","OooNgFFF9sbi","RRMNgFL99Vmm","R76XgFF9dVVV","SKnZUPf88Vee"}),14);
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
