// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// The toy company "I Can't Believe It Works!" has hired you to help develop educational toys.  The current project is a  word toy that displays four letters at all times.  Below each letter are two buttons that cause the letter above to change to the previous or next letter in alphabetical order.  So, with one click of a button the letter 'c' can be changed to a 'b' or a 'd'.  The alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click.


In order to test the toy, you would like to know if  a word can be reached from some starting word, given one or more constraints.  A constraint defines a set of forbidden words that can never be displayed by the toy.  Each constraint is formatted like "X X X X", where each X is a string of lowercase letters.  A word is defined by a constraint if the ith letter of the word is contained in the ith X of the contraint.  For example, the constraint "lf a tc e" defines the words "late", "fate", "lace" and "face".


You will be given a String start, a String finish, and a String[] forbid. Calculate and return the minimum number of button presses required for the toy to show the word finish if the toy was originally showing the word start.  Remember, the toy must never show a forbidden word.  If it is impossible for the toy to ever show the desired word, return -1.

DEFINITION
Class:SmartWordToy
Method:minPresses
Parameters:String, String, String[]
Returns:int
Method signature:int minPresses(String start, String finish, String[] forbid)


CONSTRAINTS
-start and finish will contain exactly four characters.
-start and finish will contain only lowercase letters.
-forbid will contain between 0 and 50 elements, inclusive.
-Each element of forbid will contain between 1 and 50 characters.
-Each element of forbid will contain lowercase letters and exactly three spaces.
-Each element of forbid will not contain leading, trailing or double spaces.
-Each letter within a group of letters in each element of forbid will be distinct.  Thus "aa a a a" is not allowed.
-start will not be a forbidden word.


EXAMPLES

0)
"aaaa"
"zzzz"
{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}

Returns: 8

1)
"aaaa"
"bbbb"
{}

Returns: 4

Simply change each letter one by one to the following letter in the alphabet.

2)
"aaaa"
"mmnn"
{}

Returns: 50

Just as in the previous example, we have no forbidden words.  Simply apply the correct number of button presses for each letter and you're there.

3)
"aaaa"
"zzzz"
{"bz a a a", "a bz a a", "a a bz a", "a a a bz"}

Returns: -1

Here is an example where it is impossible to go to any word from "aaaa".

4)
"aaaa"
"zzzz"
{"cdefghijklmnopqrstuvwxyz a a a", 
 "a cdefghijklmnopqrstuvwxyz a a", 
 "a a cdefghijklmnopqrstuvwxyz a", 
 "a a a cdefghijklmnopqrstuvwxyz"}

Returns: 6

5)
"aaaa"
"bbbb"
{"b b b b"}

Returns: -1

6)
"zzzz"
"aaaa"
{"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",       Проблемы могут быть только если вы бытаетесь джойнить bs_block_id с логами большого поиска.
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"}

Returns: -1

*/
// END CUT HERE

import java.util.*;

public class SmartWordToy {

    Map<String, Boolean> forbid = new HashMap<>();

    class Node {
        int distance = 0;
        int was = 0;
        int forbidden = 0;

        Node(int distance, int was, int forbidden) {
            this.distance = distance;
            this.was = was;
            this.forbidden = forbidden;
        }
    }

    public int minPresses(String start, String finish, String[] forbid) {
        int res = -1;
        if (start.equals(finish)) {
            return 0;
        }
        Node[] nodes = new Node[26 * 26 * 26 * 26];
        for (int i = 0; i < forbid.length; i++) {
            String s = forbid[i];
            String[] parts = s.split(" ");
            char[] ca1 = parts[0].toCharArray();
            char[] ca2 = parts[1].toCharArray();
            char[] ca3 = parts[2].toCharArray();
            char[] ca4 = parts[3].toCharArray();
            for (int j1 = 0; j1 < ca1.length; j1++) {
                char c = (char) (ca1[j1] - 'a');
                for (int j2 = 0; j2 < ca2.length; j2++) {
                    char c1 = (char) (ca2[j2] - 'a');
                    for (int j3 = 0; j3 < ca3.length; j3++) {
                        char c2 = (char) (ca3[j3] - 'a');
                        for (int j4 = 0; j4 < ca4.length; j4++) {
                            char c3 = (char) (ca4[j4] - 'a');
                            nodes[26 * 26 * 26 * c3 + 26 * 26 * c2 + 26 * c1 + c] = new Node(-1, 0, 1);
                        }
                    }
                }
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        nodes[hash(start.toCharArray())] = new Node(0, 1, 0);
        while (queue.size() > 0) {
            String word = queue.remove();
            int currentDistance = nodes[hash(word.toCharArray())].distance;
            for (int i = 0; i < 4; i++) {
                char[] ca = word.toCharArray();
                ca[i] = inc(ca[i]);
                int h1 = hash(ca);
                if (nodes[h1] == null) {
                    nodes[h1] = new Node(currentDistance + 1, 1, 0);
                    String s = new String(ca);
                    if (s.equals(finish)) {
                        return currentDistance + 1;
                    }
                    queue.add(s);
                }
                ca = word.toCharArray();
                ca[i] = dec(ca[i]);
                int h2 = hash(ca);
                if (nodes[h2] == null) {
                    nodes[h2] = new Node(currentDistance + 1, 1, 0);
                    String s = new String(ca);
                    if (s.equals(finish)) {
                        return currentDistance + 1;
                    }
                    queue.add(s);
                }
            }
        }
        return res;
    }

    private int hash(char[] ca) {
        return 26 * 26 * 26 * (ca[3]-'a') + 26 * 26 * (ca[2]-'a') + 26 * (ca[1]-'a') + (ca[0]-'a');
    }

    private char dec(char c) {
        return c == 'a' ? 'z' : --c;
    }

    private char inc(char c) {
        return c == 'z' ? 'a' : ++c;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new SmartWordToy()).minPresses("aaaa", "zzzz", new String[]{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}), 8);
            eq(1, (new SmartWordToy()).minPresses("aaaa", "bbbb", new String[]{}), 4);
            eq(2, (new SmartWordToy()).minPresses("aaaa", "mmnn", new String[]{}), 50);
            eq(3, (new SmartWordToy()).minPresses("aaaa", "zzzz", new String[]{"bz a a a", "a bz a a", "a a bz a", "a a a bz"}), -1);
            eq(4, (new SmartWordToy()).minPresses("aaaa", "zzzz", new String[]{"cdefghijklmnopqrstuvwxyz a a a",
                    "a cdefghijklmnopqrstuvwxyz a a",
                    "a a cdefghijklmnopqrstuvwxyz a",
                    "a a a cdefghijklmnopqrstuvwxyz"}), 6);
            eq(5, (new SmartWordToy()).minPresses("aaaa", "bbbb", new String[]{"b b b b"}), -1);
            eq(6, (new SmartWordToy()).minPresses("zzzz", "aaaa", new String[]{"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
                    "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"}), -1);
            eq(7, (new SmartWordToy()).minPresses("mmma", "yyyy",
                    new String[]{"qwertyuiopasdfg qwertyuiopasdfg qwertyuiopasdfg z", "qwertyuiopasdfg qwertyuiopasdfg hjklzxvcbnm z", "qwertyuiopasdfg hjklzxvcbnm qwertyuiopasdfg z", "qwertyuiopasdfg hjklzxvcbnm hjklzxvcbnm z", "hjklzxvcbnm qwertyuiopasdfg qwertyuiopasdfg z", "hjklzxvcbnm qwertyuiopasdfg hjklzxvcbnm z", "hjklzxvcbnm hjklzxvcbnm qwertyuiopasdfg z", "hjklzxvcbnm hjklzxvcbnm hjklzxvcbnm z", "qwertyuiopasdfg qwertyuiopasdfg z qwertyuiopasdfg", "qwertyuiopasdfg qwertyuiopasdfg z hjklzxvcbnm", "qwertyuiopasdfg hjklzxvcbnm z qwertyuiopasdfg", "qwertyuiopasdfg hjklzxvcbnm z hjklzxvcbnm", "hjklzxvcbnm qwertyuiopasdfg z qwertyuiopasdfg", "hjklzxvcbnm qwertyuiopasdfg z hjklzxvcbnm", "hjklzxvcbnm hjklzxvcbnm z qwertyuiopasdfg", "hjklzxvcbnm hjklzxvcbnm z hjklzxvcbnm", "qwertyuiopasdfg z qwertyuiopasdfg qwertyuiopasdfg", "qwertyuiopasdfg z qwertyuiopasdfg hjklzxvcbnm", "qwertyuiopasdfg z hjklzxvcbnm qwertyuiopasdfg", "qwertyuiopasdfg z hjklzxvcbnm hjklzxvcbnm", "hjklzxvcbnm z qwertyuiopasdfg qwertyuiopasdfg", "hjklzxvcbnm z qwertyuiopasdfg hjklzxvcbnm", "hjklzxvcbnm z hjklzxvcbnm qwertyuiopasdfg", "hjklzxvcbnm z hjklzxvcbnm hjklzxvcbnm", "z qwertyuiopasdfg qwertyuiopasdfg qwertyuiopasdfg", "z qwertyuiopasdfg qwertyuiopasdfg hjklzxvcbnm", "z qwertyuiopasdfg hjklzxvcbnm qwertyuiopasdfg", "z qwertyuiopasdfg hjklzxvcbnm hjklzxvcbnm", "z hjklzxvcbnm qwertyuiopasdfg qwertyuiopasdfg", "z hjklzxvcbnm qwertyuiopasdfg hjklzxvcbnm", "z hjklzxvcbnm hjklzxvcbnm qwertyuiopasdfg", "z hjklzxvcbnm hjklzxvcbnm hjklzxvcbnm", "n ablm ablm abcdefghijkl", "n ablm abcdefghijkl ablm", "n abcdefghijkl ablm ablm", "abcdefghijklm n abcdefghijklm abcdefghijklm", "abcdefghijklm abcdefghijklm n abcdefghijklm", "abcdefghijklm abcdefghijklm abcdefghijklm n", "bcdefghijklm bcdefghijkl ablm ablm", "abcdefghijkl ablm bcdefghijkl ablm", "ablm bcdefghijklm bcdefghijkl ablm", "abcdefghijkl ablm ablm bcdefghijkl", "ablm abcdefghijkl ablm bcdefghijkl", "ablm ablm bcdefghijklm bcdefghijkl"}), 228);

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
