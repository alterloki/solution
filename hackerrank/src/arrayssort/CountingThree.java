/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.01.15
 * Time: 3:15
 */
package arrayssort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CountingThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        }
        solve(arr);
    }

    private static void solve(int[] arr) {
        int[] count = new int[100];
        int[] sum = new int[100];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int prev = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = prev + count[i];
            prev = sum[i];
        }
        printArr(sum);
    }

    private static void printArr(int[] sum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(sum[i]);
        }
        System.out.println(sb.toString());
    }
}
