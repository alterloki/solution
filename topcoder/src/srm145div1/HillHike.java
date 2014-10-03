package srm145div1;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
A hiker has set out to conquer a hill.  The trail guide for the hill lists information known about the hill.  First, it lists how tall the hill is, and how far it is to the other side of the hill.  Next, it gives a list of landmarks that will be encountered while hiking the hill.  The only things that are known about these landmarks are their height, and the order in which they appear along the trail.  Finally, on this hill, there are three types of terrain:


     _____
    /:   :\
   / :   : \
  /  :   :  \
 / 1 : 2 : 3 \



Type 1: rising terrain.  In this type of terrain, the elevation of the hill rises one meter vertically for every meter that is traveled horizontally.


Type 2: level terrain.  In this type of terrain, the elevation of the hill remains constant.


Type 3: falling terrain.  This terrain's elevation falls one meter vertically for every meter that is traveled horizontally.



All three types of terrain can last for only multiples of one horizontal meter.




You will be given an int maxHeight (the maximum height of the hill, assuming the hill starts and ends at height 0), an int distance (how far horizontally one must travel to hike over the top and reach the bottom on the other side), and a int[] landmarks, which contains the heights of all the landmarks present on the trail.  The order of the elements in landmarks is the order in which they will be encountered on the trail.  All landmarks must be at least one horizontal meter apart.



Given all of this information, you must return how many different valid paths that the hiker could be facing.  A path on the hill is a sequence consisting only of the three types of terrain for the entire distance of the hill.  Two paths are different if and only if for at least one horizontal meter, the terrain type of one path is not the same as the terrain type of another path.  A path is valid if and only if the path:
1. Starts at height 0 and ends at height 0
2. Has no other locations with height 0, or height below 0 (otherwise it would be two hills, or a valley)
3. Has at least one point where the height is equal to maxHeight (otherwise, the hill would be smaller)
4. Does not go above maxHeight (otherwise, it would be taller)
5. Is laid out such that the landmarks could be placed in the order given at points on the trail.  Note that two landmarks cannot appear at the same point on the trail, even if they are at the same height.  they must be at least 1 meter apart



If no valid paths exist, return 0.


DEFINITION
Class:HillHike
Method:numPaths
Parameters:int, int, int[]
Returns:long
Method signature:long numPaths(int distance, int maxHeight, int[] landmarks)


NOTES
-The C++ 64 bit data type is long long


CONSTRAINTS
-distance will be between 2 and 100, inclusive.
-maxHeight will be between 1 and 50, inclusive.
-landmarks will contain between 0 and 50 elements, inclusive.
-Each element of landmarks will be between 1 and maxHeight, inclusive.
-The return value will be less than or equal to 2^63 - 1 (it will fit into a long)


EXAMPLES

0)
5
2
{}

Returns: 3

There are three paths with a distance of 5 and a height of 2:

            _     
           / \    _/\    /\_
          /   \  /   \  /   \
Distance: 12345  12345  12345

Notice that the 2nd and 3rd paths are mirror images, but are considered different. The following path cannot be used because it does not have a height of 2, even though it has a length of 5.

 ___
/   \
12345

The following path has a height of 2 and a length of 5, but the beginning and ending points are not the only points at height 0:

 /\       
/  \_
12345


1)
2
45
{}

Returns: 0

2)
5
2
{2,2}

Returns: 1

The only path which could contain both landmarks is:

            _
           / \
          /   \
Distance: 12345


3)
8
3
{2,2,3,1}

Returns: 7

4)
38
11
{4,5,8,5,6}

Returns: 201667830444

*/
// END CUT HERE
import java.util.*;
//TESTED
public class HillHike {
    public long numPaths(int distance, int maxHeight, int[] landmarks) {
        long res = 0;
        long[][][][] paths = new long[distance + 1][maxHeight + 1][landmarks.length + 1][2];
        paths[0][0][0][0] = 1;
        for(int d = 0; d < distance; ++d) {
            for(int h = 0; h <= maxHeight; ++h) {
                for(int lm = 0; lm <= landmarks.length; ++lm) {
                    for(int step = -1; step <= 1; ++step) {
                        for(int maxH = 0; maxH <= 1; ++maxH) {
                            int nextH = h + step;
                            if(nextH == 0 && d + 1 < distance || nextH < 0 || nextH > maxHeight) {
                                continue;
                            }
                            int currentLm = (lm < landmarks.length && h == landmarks[lm]) ? lm + 1 : lm;
                            int currentH = (h == maxHeight) ? 1 : maxH;
                            paths[d + 1][nextH][currentLm][currentH] += paths[d][h][lm][maxH];
                        }
                    }
                }
            }
        }
        return paths[distance][0][landmarks.length][1];
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new HillHike()).numPaths(5, 2, new int[] {}),3L);
            eq(1,(new HillHike()).numPaths(2, 45, new int[] {}),0L);
            eq(2,(new HillHike()).numPaths(5, 2, new int[] {2,2}),1L);
            eq(3,(new HillHike()).numPaths(8, 3, new int[] {2,2,3,1}),7L);
            eq(4,(new HillHike()).numPaths(38, 11, new int[] {4,5,8,5,6}),201667830444L);
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
