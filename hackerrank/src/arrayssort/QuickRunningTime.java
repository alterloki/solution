/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 09.01.15
 * Time: 23:26
 */
package arrayssort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class QuickRunningTime {

    static int quickSort(int[] ar) {
        return partition(ar, 0, ar.length);
    }

    static int partition(int[] ar, int from, int to) {
        int result = 0;
        if (to - from < 2) {
            return 0;
        }
        int value = ar[to - 1];
        int ind = from;
        int lt = from;

        for (int i = from; i < to - 1; i++) {
            if (ar[i] < value) {
                swap(ar, ind++, lt++);
                result++;
            } else {
                ind++;
            }
        }
        swap(ar, lt, to - 1);
        result++;
        result += partition(ar, from, lt);
        result += partition(ar, lt + 1, to);
        return result;
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public static int insertionSort(int[] A) {
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
            result += i - j - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int insertionCount = insertionSort(Arrays.copyOf(ar, ar.length));
        int quickCount = quickSort(Arrays.copyOf(ar, ar.length));
        System.out.println(insertionCount - quickCount);
    }
}
