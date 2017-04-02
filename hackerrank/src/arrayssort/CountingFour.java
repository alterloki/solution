/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.01.15
 * Time: 13:30
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CountingFour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String[] sarr = new String[n];
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            arr[i] = Integer.parseInt(parts[0]);
            if(i >= n/2) {
                sarr[i] = parts[1];
            } else {
                sarr[i] = "-";
            }
        }
        solve(arr, sarr);
    }

    private static void solve(int[] arr, String[] sarr) {
        int[] count = new int[100];
        int[] sum = new int[100];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1] + count[i - 1];
        }
        String[] result = new String[sarr.length];
        for (int i = 0; i < sarr.length; i++) {
            String s = sarr[i];
            result[sum[arr[i]]++] = s;
        }
        printArr(result);
    }

    private static void printArr(String[] sum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(sum[i]);
        }
        System.out.println(sb.toString());
    }
}
