/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 1:28
 */
package arrayssort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class FindMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(arr);
    }

    private static void solve(int[] arr) {
        System.out.println(partition(arr, 0, arr.length));
    }

    static int partition(int[] ar, int from, int to) {
        if (to - from < 2) {
            return ar[from];
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
        int middle = ar.length / 2;
        if(lt == middle) {
            return ar[lt];
        } else if(lt > middle) {
            return partition(ar, from, lt);
        } else {
            return partition(ar, lt + 1, to);
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
