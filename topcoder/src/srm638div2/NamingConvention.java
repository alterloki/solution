package srm638div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// In most programming languages variable names cannot contain spaces.
If we want a variable name that consists of two or more words, we have to encode the spaces somehow.
In this problem, we will look at two ways of doing so: Snake Case and Camel Case.
When using Snake Case, we just replace each space by an underscore ('_').
When using Camel Case, we capitalize the first letter of each word except for the first one, and then we remove all spaces.


For example, suppose that we want to declare a variable called "good morning world" (quotes for clarity).
In Snake Case, we would write this variable as "good_morning_world", while in Camel Case it would be "goodMorningWorld".


You are given a String variableName.
This String contains a valid variable name written in Snake Case.
Return the same variable name in Camel Case.

DEFINITION
Class:NamingConvention
Method:toCamelCase
Parameters:String
Returns:String
Method signature:String toCamelCase(String variableName)


CONSTRAINTS
-variableName will contain between 1 and 50 characters.
-Each character of variableName will be 'a'-'z' or '_'.
-The first and last character of variableName will not be '_'.
-variableName will not contain two consecutive underscores ('_').


EXAMPLES

0)
"sum_of_two_numbers"

Returns: "sumOfTwoNumbers"

We have 4 words: "sum", "of", "two", "numbers". So the answer is "sum" + "Of" + "Two" + "Numbers".

1)
"variable"

Returns: "variable"

Note that if we have only 1 word, then the varaible name will remain same.

2)
"t_o_p_c_o_d_e_r"

Returns: "tOPCODER"



3)
"the_variable_name_can_be_very_long_like_this"

Returns: "theVariableNameCanBeVeryLongLikeThis"



*/
// END CUT HERE
import java.util.*;
//TESTED
public class NamingConvention {
    public String toCamelCase(String variableName) {
            StringBuilder res = new StringBuilder();
            char[] ca = variableName.toCharArray();
            char prevChar = '#';
            for (int i = 0; i < ca.length; i++) {
                char c = ca[i];
                if(prevChar == '_') {
                    res.append(Character.toUpperCase(c));
                } else {
                    if(c >= 'a' && c <= 'z') {
                        res.append(c);
                    }
                }
                prevChar = c;
            }
            return res.toString();
        }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new NamingConvention()).toCamelCase("sum_of_two_numbers"),"sumOfTwoNumbers");
            eq(1,(new NamingConvention()).toCamelCase("variable"),"variable");
            eq(2,(new NamingConvention()).toCamelCase("t_o_p_c_o_d_e_r"),"tOPCODER");
            eq(3,(new NamingConvention()).toCamelCase("the_variable_name_can_be_very_long_like_this"),"theVariableNameCanBeVeryLongLikeThis");
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
