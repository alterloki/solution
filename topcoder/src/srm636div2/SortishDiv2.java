package srm636div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Everyone likes some sequences more than others.
Every person has their own function which tells them how good a sequence is.
For example, for some people this function could simply be the count of negative numbers in the sequence.

Jezalb's most favorite sequences are ones that are sorted in increasing order.
When he sees a sequence S, he immediately calculates the number of pairs of indexes i < j such that S[i] < S[j].
He calls this number the "sortedness" of S.

This morning Jezalb entered a classroom and saw a permutation of 1 through N on the blackboard.
He quickly calculated its sortedness.
He then left the classroom and forgot the permutation.
He only remembered the sortedness he computed.
You are given this value in a int sortedness.

Later that day Jezalb reentered the classroom and saw a sequence on the blackboard.
The sequence was a permutation of 1 through N, but with some elements erased.
You are given this sequence as a int[] seq with N elements.
Some of the elements in seq may be 0, which indicates an erased number.

Jezalb thinks that the sequence seq may have been obtained by erasing some elements of the sequence he saw during his first visit to the classroom.
He would like to restore the erased elements.

You are given the int sortedness and the int[] seq.
Return the number of ways in which he can fill in the missing elements into seq in such a way that the sortedness of the obtained permutation will be exactly sortedness.

DEFINITION
Class:SortishDiv2
Method:ways
Parameters:int, int[]
Returns:int
Method signature:int ways(int sortedness, int[] seq)


CONSTRAINTS
-sortedness will be between 0 and 1,000,000,000, inclusive.
-seq will contain between 1 and 100 elements, inclusive.
-Elements in seq will be between 0 and number of elements in seq, inclusive.
-Positive elements in seq will be distinct.
-Number of elements equal to 0 in seq will be between 0 and 5, inclusive.


EXAMPLES

0)
5
{4, 0, 0, 2, 0}

Returns: 2

There are six ways to fill in the missing elements. Out of those six permutations, only two have sortedness 5: {4, 1, 5, 2, 3} and {4, 3, 1, 2, 5}.

1)
4
{0, 0, 0, 0}

Returns: 5

All 5 possible ways are: {1, 3, 4, 2}, {1, 4, 2, 3}, {2, 1, 4, 3}, {2, 3, 1, 4}, {3, 1, 2, 4}.

2)
2
{1, 3, 2}

Returns: 1

There are no gaps and sortedness is indeed equal to 2.

3)
2
{1, 2, 0, 5, 0, 0}

Returns: 0

Regardless of how he fills in the gaps, the sortedness of the resulting permutation will always be greater than 2.

*/
// END CUT HERE

import java.util.ArrayList;
import java.util.List;

//TESTED
public class SortishDiv2 {

    private class Miss {
        private int position;
        private int value;

        private Miss(int position, int value) {
            this.position = position;
            this.value = value;
        }

    }

    public int ways(int sortedness, int[] seq) {
        int initialSortedness = 0;
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > 0) {
                for (int j = i + 1; j < seq.length; j++) {
                    if (seq[j] > 0 && seq[i] < seq[j]) {
                        initialSortedness++;
                    }
                }
            }
        }
        List<Miss> misses = new ArrayList<>();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == 0) {
                misses.add(new Miss(i, -1));
            }
        }
        int counter = 0;
        for (int i = 1; i <= seq.length; i++) {
            boolean was = false;
            for (int j = 0; j < seq.length; j++) {
                if (seq[j] == i) {
                    was = true;
                    break;
                }

            }
            if (!was) {
                misses.get(counter++).value = i;
            }
        }
        return rotate(seq, initialSortedness, misses.toArray(new Miss[0]), 0, sortedness);
    }

    private int rotate(int[] seq, int initialSortedness, Miss[] missedNumbers, int from, int sortedness) {
        if (from == missedNumbers.length) {
            if (checkSortedness(seq, missedNumbers, initialSortedness) == sortedness) {
                return 1;
            } else {
                return 0;
            }
        }
        int result = 0;
        for (int i = from; i < missedNumbers.length; i++) {
            swap(missedNumbers, from, i);
            result += rotate(seq, initialSortedness, missedNumbers, from + 1, sortedness);
            swap(missedNumbers, i, from);
        }
        return result;
    }

    private int checkSortedness(int[] seq, Miss[] missedNumbers, int initialSortedness) {
        int missedSortedness = 0;
        for (int i = 0; i < missedNumbers.length - 1; i++) {
            for (int j = i + 1; j < missedNumbers.length; j++) {
                if (missedNumbers[i].value < missedNumbers[j].value) {
                    missedSortedness++;
                }
            }
        }
        int addedSortedness = 0;
        for (int i = 0; i < missedNumbers.length; i++) {
            Miss missedNumber = missedNumbers[i];
            for (int j = 0; j < seq.length; j++) {
                if (j < missedNumber.position) {
                    if (seq[j] > 0 && seq[j] < missedNumber.value) {
                        addedSortedness++;
                    }
                } else {
                    if (seq[j] > 0 && seq[j] > missedNumber.value) {
                        addedSortedness++;
                    }
                }
            }
        }
        return initialSortedness + missedSortedness + addedSortedness;
    }

    private void swap(Miss[] missedNumbers, int from, int i) {
        int a = missedNumbers[from].value;
        missedNumbers[from].value = missedNumbers[i].value;
        missedNumbers[i].value = a;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new SortishDiv2()).ways(5, new int[]{4, 0, 0, 2, 0}), 2);
            eq(1, (new SortishDiv2()).ways(4, new int[]{0, 0, 0, 0}), 5);
            eq(2, (new SortishDiv2()).ways(2, new int[]{1, 3, 2}), 1);
            eq(3, (new SortishDiv2()).ways(2, new int[]{1, 2, 0, 5, 0, 0}), 0);
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
