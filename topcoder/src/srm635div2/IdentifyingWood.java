package srm635div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
We call a pair of Strings (s, t) "wood" if t is contained in s as a subsequence. (See Notes for a formal definition.)



Given Strings s and t, return the String "Yep, it's wood." (quotes for clarity) if the pair (s, t) is wood and "Nope." otherwise.


DEFINITION
Class:IdentifyingWood
Method:check
Parameters:String, String
Returns:String
Method signature:String check(String s, String t)


NOTES
-String t is contained in string s as a subsequence if we can obtain t by removing zero or more (not necessarily consecutive) characters from s.


CONSTRAINTS
-s and t will consist only of lowercase English letters.
-s and t will each be between 1 and 10 characters long, inclusive.


EXAMPLES

0)
"absdefgh"
"asdf"

Returns: "Yep, it's wood."



1)
"oxoxoxox"
"ooxxoo"

Returns: "Nope."



2)
"oxoxoxox"
"xxx"

Returns: "Yep, it's wood."



3)
"qwerty"
"qwerty"

Returns: "Yep, it's wood."



4)
"string"
"longstring"

Returns: "Nope."



*/
// END CUT HERE
import java.util.*;
//TESTED
public class IdentifyingWood {
    public String check(String s, String t) {
        String res = "Yep, it's wood.";
        int from = 0;
        char[] tca = t.toCharArray();
        for (int i = 0; i < tca.length; i++) {
            char c = tca[i];
            int index = s.indexOf(c, from);
            if(index >= 0) {
                from = index + 1;
            } else {
                return "Nope.";
            }
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new IdentifyingWood()).check("absdefgh", "asdf"),"Yep, it's wood.");
            eq(1,(new IdentifyingWood()).check("oxoxoxox", "ooxxoo"),"Nope.");
            eq(2,(new IdentifyingWood()).check("oxoxoxox", "xxx"),"Yep, it's wood.");
            eq(3,(new IdentifyingWood()).check("qwerty", "qwerty"),"Yep, it's wood.");
            eq(4,(new IdentifyingWood()).check("string", "longstring"),"Nope.");
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
