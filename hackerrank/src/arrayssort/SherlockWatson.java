/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 2:02
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockWatson {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < q; i++) {
            System.out.println(rotate(arr, k, scanner.nextInt()));
        }
    }

    private static int rotate(int[] arr, int k, int x) {
        k = k % arr.length;
        int newIndex = x >= k ? x - k : arr.length - (k - x);
        return arr[newIndex];
    }
}
