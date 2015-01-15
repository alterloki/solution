/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 2:59
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class AlmostSorted {

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
        int l = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                l = i - 1;
                break;
            }
        }
        if (l >= 0) {
            int r = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] >= arr[i + 1]) {
                    r = i + 1;
                    break;
                }
            }
            if (trySwap(arr, l, r)) {
                System.out.println("yes");
                System.out.println("swap " + (l + 1) + " " + (r + 1));
            } else if (tryReverse(arr, l, r)) {
                System.out.println("yes");
                System.out.println("reverse " + (l + 1) + " " + (r + 1));
            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("yes");
        }
    }

    private static boolean tryReverse(int[] arr, int l, int r) {
        for(int i = l; i < l + (r - l + 1) / 2; i++) {
            swap(arr, i, r - i + l);
        }
        return checkSorted(arr);
    }

    private static boolean trySwap(int[] arr, int l, int r) {
        swap(arr, l, r);
        if (checkSorted(arr)) {
            return true;
        } else {
            swap(arr, l, r);
            return false;
        }
    }

    private static boolean checkSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
