/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.01.15
 * Time: 13:40
 */
package arrayssort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(arr);
    }

    private static void solve(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if(diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(new int[]{arr[i - 1], arr[i]});
            } else if(diff == minDiff) {
                result.add(new int[]{arr[i - 1], arr[i]});
            }
        }
        printResult(result);
    }

    private static void printResult(List<int[]> result) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(result.get(i)[0]).append(" ").append(result.get(i)[1]);
        }
        System.out.println(sb.toString());
    }
}
