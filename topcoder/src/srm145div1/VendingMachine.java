package srm145div1;// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Note that in the following problem statement, all quotes and angle brackets are for clarity



A certain vending machine delves out its goods from a rotating cylinder, which can rotate around in both clockwise and counter-clockwise directions.  The cylinder has a number of shelves on it, and each shelf is divided into a number of columns.  On the front of the machine, there is a panel of doors that extends the entire height of the column.  There is one door for each shelf, which is the width of one column.  When a purchase is made, the user uses two buttons to rotate the cylinder so their purchase is located at a door.  They make their purchase by sliding the appropriate door open, and removing the item (there can only be one item per column on a particular shelf).  The cylinder can rotate in a complete circle, and so there are always two ways to get from a particular column to another column.



Because the vending machine company wants to sell the most expensive items possible, and the machine can only show one column at a time, the machine will always try to put forth the most expensive column available.  The price of a column is calculated by adding up all the prices of the remaining items in that column.  The most expensive column is defined to be the one with the maximum price.  If 5 minutes have elapsed since the last purchase was made, the machine rotates the cylinder to the most expensive column.  If, however, another purchase has been made before the 5 minutes are up, the rotation does not occur, and the 5 minute timer is reset.



Recently, some machines' rotating motors have been failing early, and the company wants to see if it is because the machines rotate to show their expensive column too often.  To determine this, they have hired you to simulate purchases and see how long the motor is running.



You will be given the prices of all the items in the vending machine in a String[].  Each element of prices will be a single-space separated list of integers, which are the prices (in cents) of the items.  The Nth integer in the Mth element of prices represents the price of the Nth column in the Mth shelf in the cylinder.  You will also be given a String[] purchases.  Each element in purchases will be in the format: "<shelf>,<column>:<time>"
<shelf> is a 0-based integer which identifies the shelf that the item was purchased from.  <column> is a 0-based integer which identifies the column the item was purchased from.  <time> is an integer which represents the time, in minutes, since the machine was turned on.



In the simulation, the motor needs to run for 1 second in order to rotate to an adjacent column.  When the machine is turned on, column 0 is facing out, and it immediately rotates to the most expensive column, even if the first purchase is at time 0.  The machine also rotates to the most expensive column at the end of the simulation, after the last purchase.  Note that when an item is purchased, its price is no longer used in calculating the price of the column it is in.  When the machine rotates to the most expensive column, or when a user rotates the cylinder, the rotation is in the direction which takes the least amount of time.  For example, in a 4-column cylinder, if column 0 is displayed, and the cylinder is rotated to column 3, it can be rotated backwards, which takes 1 second, versus rotating forwards which takes 3 seconds.



If a user tries to purchase an item that was already purchased, this is an incorrect simulation, and your method should return -1.  Otherwise, your method should return how long the motor was running, in seconds.



DEFINITION
Class:VendingMachine
Method:motorUse
Parameters:String[], String[]
Returns:int
Method signature:int motorUse(String[] prices, String[] purchases)


NOTES
-When rotating to the most expensive column, if two columns have the same price, rotate to the one with the lowest column number (see example 0).
-If two purchases are less than 5 minutes apart, the machine does not perform a rotation to the most expensive column between the purchases.  If two purchases are 5 or more minutes apart, the machine rotates to the most expensive column between the two purchases.


CONSTRAINTS
-prices will have between 1 and 50 elements, inclusive.
-Each element of prices will have between 5 and 50 characters, is a single-space separated list of integers, and has no leading or trailing spaces.
-Each element of prices will have the same number of integers in it.
-Each element of prices will have at least 3 integers in it.
-Each integer in prices will be between 1 and 10000, inclusive, and will not contain leading 0's.
-purchases will have between 1 and 50 elements, inclusive.
-Each element of purchases will be in the format "<shelf>,<column>:<time>" (angle brackets and quotes are for clarity only), where <shelf>, <column>, and <time> are all integers.
-In each element of purchases, <shelf> will be between 0 and M - 1, inclusive, where M is the number of elements in prices.
-In each element of purchases, <column> will be between 0 and N - 1, inclusive, where N is the number of integers in each element of prices.
-In each element of purchases, <time> will be between 0 and 1000, inclusive.
-In each element of purchases, <shelf>, <column>, and <time> will not contain extra leading 0's.
-purchases will be sorted in strictly ascending order by <time>.  This means that each purchase must occur later than all previous ones.


EXAMPLES

0)
{"100 100 100"}
{"0,0:0", "0,2:5", "0,1:10"}

Returns: 4


The vending machine has three columns, and only one row.  Since all three items are the same price, they are all the most expensive, and therefore, the lowest numbered column is rotated to.  Since the machine starts out at column 0, no rotation is performed before the first purchase.  The starting configuration is (*'s denote the currently displayed column):

 
+-----+-----+-----+
| 100 | 100 | 100 |
+*****+-----+-----+



In the first purchase, the customer does not rotate the cylinder because the item he wants is already displayed. The configuration of the vending machine is now:


+-----+-----+-----+
|  0  | 100 | 100 |
+*****+-----+-----+


Since the next purchase is at least 5 minutes away, the machine performs a rotation to the most expensive column.  Both column 1 and 2 are now 100 apiece, so it rotates to the smallest index of these, column 1.  The fastest way there is to rotate forward 1 column, yielding 1 second of motor use:


+-----+-----+-----+
|  0  | 100 | 100 |
+-----+*****+-----+



The next customer purchases the item in column 2, which is 1 column away, so add 1 second to the motor use.  Because another 5 minutes passes, the most expensive column is displayed, which is now column 1.  Add 1 more second for the rotation.  The configuration is now:


+-----+-----+-----+
|  0  | 100 |  0  |
+-----+*****+-----+



The final customer purchases from column 1, (which is already displayed), and the final most expensive column is rotated to.  Since all columns are the same price again (0), column 0 is displayed.  It takes 1 second to get back there, so add 1 more second.


1)
{"100 200 300 400 500 600"}
{"0,2:0", "0,3:5", "0,1:10", "0,4:15"}

Returns: 17


The most expensive column during this whole example is column 5.  Since all purchases are at least 5 minutes apart, the most expensive column is rotated to each time.



Before the purchases start, add 1 second for rotating to column 5.
The first purchase  is 3 columns away, so add 3 seconds to get there, and 3 seconds to get back to column 5
The second purchase is 2 columns away, so add 4 seconds to get there and back.
The third purchase is also 2 columns away, so add 4 more seconds.
The final purchase is only one column away, so add 2 more seconds.



The final configuration is:


+-----+-----+-----+-----+-----+-----+
| 100 |  0  |  0  |  0  |  0  | 600 |
+-----+-----+-----+-----+-----+*****+



2)
{"100 200 300 400 500 600"}
{"0,2:0", "0,3:4", "0,1:8", "0,4:12"}

Returns: 11


This is the same as example 1, except now, the purchases are all less than 5 minutes apart.


3)
{"100 100 100"}
{"0,0:10", "0,0:11"}

Returns: -1


The second purchase is illegal since the item was already purchased


4)
{"100 200 300",
 "600 500 400"}
{"0,0:0", "1,1:10", "1,2:20",
 "0,1:21", "1,0:22", "0,2:35"}

Returns: 6


A two-row example.  The configurations just before each purchase are:


purchase 1:
+-----+-----+-----+
| 100 | 200 | 300 |
+-----+-----+-----+
| 600 | 500 | 400 |
+*****+-----+-----+

purchase 2:
+-----+-----+-----+
|  0  | 200 | 300 |
+-----+-----+-----+
| 600 | 500 | 400 |
+-----+*****+-----+

purchase 3:
+-----+-----+-----+
|  0  | 200 | 300 |
+-----+-----+-----+
| 600 |  0  | 400 |
+-----+-----+*****+

purchase 4:
+-----+-----+-----+
|  0  | 200 | 300 |
+-----+-----+-----+
| 600 |  0  |  0  |
+-----+-----+*****+

purchase 5:
+-----+-----+-----+
|  0  |  0  | 300 |
+-----+-----+-----+
| 600 |  0  |  0  |
+-----+*****+-----+

purchase 6:
+-----+-----+-----+
|  0  |  0  | 300 |
+-----+-----+-----+
|  0  |  0  |  0  |
+-----+-----+*****+

final:
+-----+-----+-----+
|  0  |  0  |  0  |
+-----+-----+-----+
|  0  |  0  |  0  |
+*****+-----+-----+


*/
// END CUT HERE

import java.util.*;
//TESTED
public class VendingMachine {

    class Pos {
        int shelf;
        int column;

        Pos(int shelf, int column) {
            this.shelf = shelf;
            this.column = column;
        }
    }

    static class State {
        int currentColumn;
        int cylinderSize;

        State(int currentColumn, int cylinderSize) {
            this.currentColumn = currentColumn;
            this.cylinderSize = cylinderSize;
        }

        //retruns time
        public int rotate(int destination) {
            int clockCounter = destination - currentColumn;
            if (clockCounter < 0) {
                clockCounter = cylinderSize + clockCounter;
            }
            int clockWise = cylinderSize - Math.abs(clockCounter);
            currentColumn = destination;
            return Math.min(clockCounter, clockWise);
        }
    }

    public int motorUse(String[] prices, String[] purchases) {
        int res = 0;
        int[][] goodsPrices = new int[prices.length][];
        for (int i = 0; i < prices.length; i++) {
            String price = prices[i];
            String[] shelfParts = price.split(" ");
            goodsPrices[i] = new int[shelfParts.length];
            for (int j = 0; j < shelfParts.length; j++) {
                goodsPrices[i][j] = Integer.parseInt(shelfParts[j]);
            }
        }
        int[] columnPrices = new int[goodsPrices[0].length];
        for (int i = 0; i < goodsPrices.length; i++) {
            int[] shellPrices = goodsPrices[i];
            for (int j = 0; j < shellPrices.length; j++) {
                int cellPrice = shellPrices[j];
                columnPrices[j] += cellPrice;
            }
        }
        SortedMap<Integer, Pos> purchasesMap = new TreeMap<>();
        for (int i = 0; i < purchases.length; i++) {
            String purchase = purchases[i];
            String[] parts1 = purchase.split(":");
            int time = Integer.parseInt(parts1[1]);
            String[] parts2 = parts1[0].split(",");
            Pos position = new Pos(Integer.parseInt(parts2[0]), Integer.parseInt(parts2[1]));
            purchasesMap.put(time, position);
        }
        State state = new State(0, goodsPrices[0].length);
        int currentMaximum = getCurrentMaximum(columnPrices);
        int currentTime = 0;
        if (currentMaximum != 0) {
            res += state.rotate(currentMaximum);
        }
        for (Map.Entry<Integer, Pos> entry : purchasesMap.entrySet()) {
            Integer purchaseTime = entry.getKey();
            if (purchaseTime - currentTime >= 5 && state.currentColumn != currentMaximum) {
                res += state.rotate(currentMaximum);
            }
            currentTime = purchaseTime;
            Pos purchasePosition = entry.getValue();
            res += state.rotate(purchasePosition.column);
            if (goodsPrices[purchasePosition.shelf][purchasePosition.column] > 0) {
                columnPrices[purchasePosition.column] -= goodsPrices[purchasePosition.shelf][purchasePosition.column];
                goodsPrices[purchasePosition.shelf][purchasePosition.column] = 0;
            } else {
                return -1;
            }
            if (purchasePosition.column == currentMaximum) {
                currentMaximum = getCurrentMaximum(columnPrices);
            }
        }
        res += state.rotate(currentMaximum);
        return res;
    }

    private int getCurrentMaximum(int[] columnPrices) {
        int max = -1;
        int result = -1;
        for (int i = 0; i < columnPrices.length; i++) {
            int columnPrice = columnPrices[i];
            if (columnPrice > max) {
                max = columnPrice;
                result = i;
            }
        }
        return result;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new VendingMachine()).motorUse(new String[]{"100 100 100"}, new String[]{"0,0:0", "0,2:5", "0,1:10"}), 4);
            eq(1, (new VendingMachine()).motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:5", "0,1:10", "0,4:15"}), 17);
            eq(2, (new VendingMachine()).motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:4", "0,1:8", "0,4:12"}), 11);
            eq(3, (new VendingMachine()).motorUse(new String[]{"100 100 100"}, new String[]{"0,0:10", "0,0:11"}), -1);
            eq(4, (new VendingMachine()).motorUse(new String[]{"100 200 300",
                    "600 500 400"}, new String[]{"0,0:0", "1,1:10", "1,2:20",
                    "0,1:21", "1,0:22", "0,2:35"}), 6);
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
