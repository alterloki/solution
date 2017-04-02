package srm636div2;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Mirosz adores sweets.
He has just bought a rectangular bar of chocolate.
The bar is divided into a grid of square cells.
Different cells may have a different quality.
You are given the description of the bar in a String[] chocolate.
Each character in chocolate is a digit between '0' and '9', inclusive: the quality of one of the cells.

Mirosz is now going to divide the chocolate into 16 parts: one for him and one for each of his 15 friends.
He will do the division by making six cuts: three horizontal and three vertical ones.
Each cut must go between two rows or columns of cells.
Each of the 16 parts must be non-empty.
The quality of a part is the sum of the qualities of all cells it contains.

Mirosz is well-mannered and he will let his friends choose their pieces first.
His friends are even more addicted to chocolate than he is.
Therefore, they will certainly choose the pieces with higher quality first, and Mirosz will be left with the worst of the 16 pieces.

You are given the String[] chocolate.
Find the optimal places for the six cuts.
More precisely, compute and return the largest possible quality of Mirosz's part of the chocolate bar.

DEFINITION
Class:ChocolateDividingHard
Method:findBest
Parameters:String[]
Returns:int
Method signature:int findBest(String[] chocolate)


CONSTRAINTS
-chocolate will contain between 4 and 75 elements, inclusive. 
-All elements in chocolate will contain between 4 and 75 characters, inclusive. 
-All elements in chocolate will contain the same number of characters. 
-All elements in chocolate will contain only digits.


EXAMPLES

0)
{
"95998",
"21945",
"23451",
"99798",
"74083"
}

Returns: 3

One of two optimal ways to cut this chocolate is shown below. 

9 | 5 | 9 9 | 8 
--|---|-----|--- 
2 | 1 | 9 4 | 5 
2 | 3 | 4 5 | 1 
--|---|-----|--- 
9 | 9 | 7 9 | 8 
--|---|-----|--- 
7 | 4 | 0 8 | 3 

This way of cutting produces parts with the following qualities: 9, 5, 18, 8, 4, 4, 22, 6, 9, 9, 16, 8, 7, 4, 8, 3. The quality of the worst part (the one that Mirosz will get) is 3. 

Here is another way of cutting the same chocolate: 

9 | 5 9 | 9 | 8 
--|-----|---|--- 
2 | 1 9 | 4 | 5 
--|-----|---|--- 
2 | 3 4 | 5 | 1 
9 | 9 7 | 9 | 8 
--|-----|---|--- 
7 | 4 0 | 8 | 3  

If Mirosz cuts the chocolate in this way, the quality of his part will be 2, which is worse than 3.

1)
{
"12942",
"23456",
"99798",
"98998",
"67675"
}

Returns: 5



2)
{
"129420",
"234560",
"997980",
"989980",
"676760"
}

Returns: 6



3)
{"75356291270936062","61879202375922897","36129319478450361","06320615547656937","45254744307868843","14920689266495048","71727226106159490","91771159776736563","94812939088509638","56115984810304444","76317596217857418","59753883189643338"}

Returns: 44



*/
// END CUT HERE

import java.util.*;
//TESTED
public class ChocolateDividingHard {

    private int[][] sums = null;

    public int findBest(String[] chocolate) {
        fillSums(chocolate);
        //find max r
        int low = 0;
        int high = 9 * 75 * 75;
        int w = chocolate[0].length();
        int h = chocolate.length;

        while (low + 1 < high) {
            int avg = (high + low) / 2;
            if (isPossible(chocolate, avg, w, h)) {
                low = avg;
            } else {
                high = avg;
            }
        }

        return low;
    }

    private boolean isPossible(String[] chocolate, int r, int w, int h) {
        for (int y1 = 1; y1 < h - 2; y1++) {
            for (int y2 = y1 + 1; y2 < h - 1; y2++) {
                for (int y3 = y2 + 1; y3 < h; y3++) {
                    int left = 0;
                    for (int i = 0; i < 3 && left < w; i++) {
                        int low = 0;
                        int high = w - left;
                        while (low + 1 < high) {
                            int right = (low + high) / 2;
                            if (allAtLeast(left, right, y1, y2, y3, r, h - 1)) {
                                high = right;
                            } else {
                                low = right;
                            }
                        }
                        left += high;
                    }
                    if(left < w) {
                        if(allAtLeast(left, w - left, y1, y2, y3, r, h - 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * start [0;w-1], delta [1;w]
     */
    private boolean allAtLeast(int start, int delta, int y1, int y2, int y3, int r, int h) {
        if(delta == 0) {
            return false;
        }
        if (quadSum(start, 0, start + delta - 1, y1 - 1) >= r && quadSum(start, y1, start + delta - 1, y2 - 1) >= r &&
                quadSum(start, y2, start + delta - 1, y3 - 1) >= r && quadSum(start, y3, start + delta - 1, h) >= r) {
            return true;
        } else {
            return false;
        }
    }


    private void fillSums(String[] chocolate) {
        sums = new int[chocolate.length][chocolate[0].length()];
        for (int y = 0; y < chocolate.length; y++) {
            char[] ca = chocolate[y].toCharArray();
            for (int x = 0; x < ca.length; x++) {
                char c = ca[x];
                sums[y][x] = c - '0' + (y == 0 ? 0 : sums[y - 1][x]) + (x == 0 ? 0 : sums[y][x - 1]) - (y == 0 || x == 0 ? 0 : sums[y - 1][x - 1]);
            }
        }
    }

    private int quadSum(int x1, int y1, int x2, int y2) {
        return sums[y2][x2] - (y1 == 0 ? 0 : sums[y1 - 1][x2]) - (x1 == 0 ? 0 : sums[y2][x1 - 1]) + (x1 == 0 || y1 == 0 ? 0 : sums[y1 - 1][x1 - 1]);
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new ChocolateDividingHard()).findBest(new String[]{
                    "95998",
                    "21945",
                    "23451",
                    "99798",
                    "74083"
            }), 3);
            eq(1, (new ChocolateDividingHard()).findBest(new String[]{
                    "12942",
                    "23456",
                    "99798",
                    "98998",
                    "67675"
            }), 5);
            eq(2, (new ChocolateDividingHard()).findBest(new String[]{
                    "129420",
                    "234560",
                    "997980",
                    "989980",
                    "676760"
            }), 6);
            eq(3, (new ChocolateDividingHard()).findBest(new String[]{"75356291270936062", "61879202375922897", "36129319478450361", "06320615547656937", "45254744307868843", "14920689266495048", "71727226106159490", "91771159776736563", "94812939088509638", "56115984810304444", "76317596217857418", "59753883189643338"}), 44);
            eq(4, (new ChocolateDividingHard()).findBest(new String[]{"00008805200110656", "00082000008822000", "80000057000005006", "00050500002075854"}), 0);
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
