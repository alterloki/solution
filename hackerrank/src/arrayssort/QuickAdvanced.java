/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 09.01.15
 * Time: 23:45
 */
package arrayssort;

import java.util.*;

/**
 * @author ashevenkov
 */
public class QuickAdvanced {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = in.nextInt();
            }
            long c = insertSort(ar);
            System.out.println(c);
        }
    }


    private static class BIT {

        private long[] values;

        private BIT(int count) {
            this.values = new long[count + 1];
        }

        public void addValue(int index, int value) {
            while (index < values.length) {
                values[index] += value;
                index += index & -index;
            }
        }

        public long sum(int to) {
            long result = 0;
            while (to > 0) {
                result += values[to];
                to -= to & -to;
            }
            return result;
        }

        public long sum(int from, int to) {
            return sum(to) - sum(from);
        }
    }

    public static long insertSort(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value > max) {
                max = value;
            }
        }
        long result = 0;
        BIT bit = new BIT(max);
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            result += bit.sum(value, max);
            bit.addValue(value, 1);
        }
        return result;
    }
}
