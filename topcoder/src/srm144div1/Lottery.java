package srm144div1;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// In most states, gamblers can choose from a wide variety of different lottery games.  The rules of a lottery are defined by two integers (choices and blanks) and two boolean variables (sorted and unique).  choices represents the highest valid number that you may use on your lottery ticket.  (All integers between 1 and choices, inclusive, are valid and can appear on your ticket.)  blanks represents the number of spots on your ticket where numbers can be written.

The sorted and unique variables indicate restrictions on the tickets you can create.  If sorted is set to true, then the numbers on your ticket must be written in non-descending order.  If sorted is set to false, then the numbers may be written in any order.  Likewise, if unique is set to true, then each number you write on your ticket must be distinct.  If unique is set to false, then repeats are allowed.

Here are some example lottery tickets, where choices = 15 and blanks = 4:
{3, 7, 12, 14} -- this ticket is unconditionally valid.
{13, 4, 1, 9} -- because the numbers are not in nondescending order, this ticket is valid only if sorted = false.
{8, 8, 8, 15} -- because there are repeated numbers, this ticket is valid only if unique = false.
{11, 6, 2, 6} -- this ticket is valid only if sorted = false and unique = false.

Given a list of lotteries and their corresponding rules, return a list of lottery names sorted by how easy they are to win.  The probability that you will win a lottery is equal to (1 / (number of valid lottery tickets for that game)).  The easiest lottery to win should appear at the front of the list.  Ties should be broken alphabetically (see example 1).

DEFINITION
Class:Lottery
Method:sortByOdds
Parameters:String[]
Returns:String[]
Method signature:String[] sortByOdds(String[] rules)


CONSTRAINTS
-rules will contain between 0 and 50 elements, inclusive.
-Each element of rules will contain between 11 and 50 characters, inclusive.
-Each element of rules will be in the format "<NAME>:_<CHOICES>_<BLANKS>_<SORTED>_<UNIQUE>" (quotes for clarity). The underscore character represents exactly one space. The string will have no leading or trailing spaces.
-<NAME> will contain between 1 and 40 characters, inclusive, and will consist of only uppercase letters ('A'-'Z') and spaces (' '), with no leading or trailing spaces.
-<CHOICES> will be an integer between 10 and 100, inclusive, with no leading zeroes.
-<BLANKS> will be an integer between 1 and 8, inclusive, with no leading zeroes.
-<SORTED> will be either 'T' (true) or 'F' (false).
-<UNIQUE> will be either 'T' (true) or 'F' (false).
-No two elements in rules will have the same name.


EXAMPLES

0)
{"PICK ANY TWO: 10 2 F F"
,"PICK TWO IN ORDER: 10 2 T F"
,"PICK TWO DIFFERENT: 10 2 F T"
,"PICK TWO LIMITED: 10 2 T T"}

Returns: { "PICK TWO LIMITED",  "PICK TWO IN ORDER",  "PICK TWO DIFFERENT",  "PICK ANY TWO" }

The "PICK ANY TWO" game lets either blank be a number from 1 to 10.  Therefore, there are 10 * 10 = 100 possible tickets, and your odds of winning are 1/100.

The "PICK TWO IN ORDER" game means that the first number cannot be greater than the second number.  This eliminates 45 possible tickets, leaving us with 55 valid ones.  The odds of winning are 1/55.

The "PICK TWO DIFFERENT" game only disallows tickets where the first and second numbers are the same.  There are 10 such tickets, leaving the odds of winning at 1/90.

Finally, the "PICK TWO LIMITED" game disallows an additional 10 tickets from the 45 disallowed in "PICK TWO IN ORDER".  The odds of winning this game are 1/45.

1)
{"INDIGO: 93 8 T F",
 "ORANGE: 29 8 F T",
 "VIOLET: 76 6 F F",
 "BLUE: 100 8 T T",
 "RED: 99 8 T T",
 "GREEN: 78 6 F T",
 "YELLOW: 75 6 F F"}


Returns: { "RED",  "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "INDIGO",  "VIOLET" }

Note that INDIGO and BLUE both have the exact same odds (1/186087894300).  BLUE is listed first because it comes before INDIGO alphabetically.

2)
{}

Returns: { }

Empty case

*/
// END CUT HERE

import java.util.*;
//TESTED
public class Lottery {
    public String[] sortByOdds(String[] rules) {
        String[] res = new String[rules.length];
        LotteryElement[] elements = new LotteryElement[rules.length];
        for (int i = 0; i < rules.length; i++) {
            String rule = rules[i];
            LotteryElement lotteryElement = new LotteryElement(rule);
            elements[i] = lotteryElement;
        }
        Arrays.sort(elements);
        for (int i = 0; i < elements.length; i++) {
            LotteryElement element = elements[i];
            res[i] = element.name;
        }
        return res;
    }

    public class LotteryElement implements Comparable<LotteryElement> {
        public int type;
        public String name;
        public int nChoises;
        public int kBlanks;

        public Long result = 0L;

        public LotteryElement(String rule) {
            String[] parts = rule.split(": ");
            name = parts[0];
            String[] parts1 = parts[1].split(" ");
            nChoises = Integer.parseInt(parts1[0]);
            kBlanks = Integer.parseInt(parts1[1]);
            boolean sorted = parts1[2].equals("T");
            boolean unique = parts1[3].equals("T");
            if (sorted) {
                if (unique) {
                    type = 0;
                } else {
                    type = 1;
                }
            } else {
                if (unique) {
                    type = 2;
                } else {
                    type = 3;
                }
            }
            calculate();
        }

        private void calculate() {
            if (type == 0) {
                result = cnk(nChoises, kBlanks);
            } else if (type == 1) {
                result = cdnk(nChoises, kBlanks);
            } else if (type == 2) {
                result = ank(nChoises, kBlanks);
            } else if (type == 3) {
                result = adnk(nChoises, kBlanks);
            }
        }

        public int compareTo(LotteryElement o) {
            int i = result.compareTo(o.result);
            if (i == 0) {
                i = name.compareTo(o.name);
            }
            return i;
        }
    }

    private Long adnk(int nChoises, int kBlanks) {
        return (long) Math.pow(nChoises, kBlanks);
    }

    private Long ank(int nChoises, int kBlanks) {
        long result = 1;
        for (int i = nChoises - kBlanks + 1; i <= nChoises; i++) {
            result *= i;
        }
        return result;
    }

    private Long cdnk(int nChoises, int kBlanks) {
        long result = 1;
        for (int i = nChoises; i <= nChoises + kBlanks - 1; i++) {
            result *= i;
        }
        for (int i = 1; i <= kBlanks; i++) {
            result /= i;
        }
        return result;
    }

    private long cnk(int nChoises, int kBlanks) {
        long result = 1;
        for (int i = nChoises - kBlanks + 1; i <= nChoises; i++) {
            result *= i;
        }
        for (int i = 1; i <= kBlanks; i++) {
            result /= i;
        }
        return result;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new Lottery()).sortByOdds(new String[]{"PICK ANY TWO: 10 2 F F"
                    , "PICK TWO IN ORDER: 10 2 T F"
                    , "PICK TWO DIFFERENT: 10 2 F T"
                    , "PICK TWO LIMITED: 10 2 T T"}), new String[]{"PICK TWO LIMITED", "PICK TWO IN ORDER", "PICK TWO DIFFERENT", "PICK ANY TWO"});
            eq(1, (new Lottery()).sortByOdds(new String[]{"INDIGO: 93 8 T F",
                    "ORANGE: 29 8 F T",
                    "VIOLET: 76 6 F F",
                    "BLUE: 100 8 T T",
                    "RED: 99 8 T T",
                    "GREEN: 78 6 F T",
                    "YELLOW: 75 6 F F"}
            ), new String[]{"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "INDIGO", "VIOLET"});
            eq(2, (new Lottery()).sortByOdds(new String[]{}), new String[]{});
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
