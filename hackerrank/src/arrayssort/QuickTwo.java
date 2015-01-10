/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 07.01.15
 * Time: 23:46
 */
package arrayssort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class QuickTwo {
    static void quickSort(int[] ar) {
        partition(ar, 0, ar.length);
    }

    static void partition(int[] ar, int from, int to) {
        if (to - from < 2) {
            return;
        }
        int valueCount = 0;
        int value = ar[from];
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for (int i = from; i < to; i++) {
            int a = ar[i];
            if (a < value) {
                less.add(a);
            } else if (a > value) {
                more.add(a);
            } else {
                valueCount++;
            }
        }
        for (int i = 0; i < less.size(); i++) {
            ar[from + i] = less.get(i);
        }
        for (int i = from + less.size(); i < from + less.size() + valueCount; i++) {
            ar[i] = value;
        }
        for (int i = 0; i < more.size(); i++) {
            ar[from + i + less.size() + valueCount] = more.get(i);
        }
        partition(ar, from, from + less.size());
        partition(ar, from + less.size() + valueCount, to);
        printArray(ar, from, to);
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
