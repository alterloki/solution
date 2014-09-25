package srm631div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Cat Taro has a square grid with N rows and N columns.
Each cell of the grid is painted either black or white.
You are given a String[] grid which represents the current state of the grid.
Each element of grid represents one row of the grid.
In grid, the character 'W' represents a white cell, and the character 'B' represents a black cell. 




Taro wants to choose a set of consecutive cells that are in the same column and are painted in the same color.
Return the largest number of cells he can choose.


DEFINITION
Class:TaroGrid
Method:getNumber
Parameters:String[]
Returns:int
Method signature:int getNumber(String[] grid)


CONSTRAINTS
-N will be between 1 and 50, inclusive.
-grid will contain exactly N elements.
-Each element of grid will contain exactly N characters.
-Each character in grid will be 'W' or 'B'.


EXAMPLES

0)
{"W"}

Returns: 1



1)
{"WB",
 "BW"}

Returns: 1



2)
{"BWW",
 "BBB",
 "BWB"}

Returns: 3

He can choose the entire leftmost column (i.e., character 0 of each element of grid).

3)
{"BWBW",
 "BBWB",
 "WWWB",
 "BWWW"}

Returns: 3



4)
{"BWB",
 "BBW",
 "BWB"}

Returns: 3



5)
{"BBWWBBWW",
 "BBWWBBWW",
 "WWBBWWBB",
 "WWBBWWBB",
 "BBWWBBWW",
 "BBWWBBWW",
 "WWBBWWBB",
 "WWBBWWBB"}

Returns: 2

Note that the chosen cells must be consecutive.

*/
// END CUT HERE
//TESTED
public class TaroGrid {
    public int getNumber(String[] grid) {
        int n = grid.length;
        int max = 0;
        int[][] igrid = new int[n][];
        for(int i = 0; i < n; i++) {
            igrid[i] = new int[n];
            for(int j = 0; j < n; j++) {
                igrid[i][j] = grid[j].charAt(i) == 'B' ? 1 : 0;
            }
        }
        for(int i = 0; i < n; i++) {
            int local = getMaxCount(igrid[i]);
            if(local > max) {
                max = local;
            }
        }
        return max;
    }

    private int getMaxCount(int[] ints) {
        int prev = ints[0];
        int localMax = 0;
        int curL = 0;
        for(int i = 0; i < ints.length; i++) {
            if(ints[i] == prev) {
                curL++;
            } else {
                curL = 1;
            }
            if(curL > localMax) {
                localMax = curL;
            }
            prev = ints[i];
        }
        return localMax;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TaroGrid()).getNumber(new String[] {"W"}),1);
            eq(1,(new TaroGrid()).getNumber(new String[] {"WB",
                "BW"}),1);
            eq(2,(new TaroGrid()).getNumber(new String[] {"BWW",
                "BBB",
                "BWB"}),3);
            eq(3,(new TaroGrid()).getNumber(new String[] {"BWBW",
                "BBWB",
                "WWWB",
                "BWWW"}),3);
            eq(4,(new TaroGrid()).getNumber(new String[] {"BWB",
                "BBW",
                "BWB"}),3);
            eq(5,(new TaroGrid()).getNumber(new String[] {"BBWWBBWW",
                "BBWWBBWW",
                "WWBBWWBB",
                "WWBBWWBB",
                "BBWWBBWW",
                "BBWWBBWW",
                "WWBBWWBB",
                "WWBBWWBB"}),2);
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
