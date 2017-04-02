/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 08.01.15
 * Time: 19:48
 */
package arrayssort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class QuicksortInPlace {

    static void quickSort(int[] ar) {
        partition(ar, 0, ar.length);
    }

    static void partition(int[] ar, int from, int to) {
        if (to - from < 2) {
            return;
        }
        int value = ar[to - 1];
        int ind = from;
        int lt = from;

        for (int i = from; i < to - 1; i++) {
            if (ar[i] < value) {
                swap(ar, ind++, lt++);
            } else {
                ind++;
            }
        }
        swap(ar, lt, to - 1);
        printArray(ar, 0, ar.length);
        partition(ar, from, lt);
        partition(ar, lt + 1, to);
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    static void printArray(int[] ar, int from, int to) {
        for (int i = from; i < to; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }
}
