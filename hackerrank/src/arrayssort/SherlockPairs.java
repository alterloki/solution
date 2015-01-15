/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 2:20
 */
package arrayssort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(solve(arr));
        }
    }

    private static long solve(int[] arr) {
        long result = 0;
        Arrays.sort(arr);
        int currentCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > 1) {
                    result += variations(currentCount);
                    currentCount = 1;
                }
            }
        }
        if (currentCount > 1) {
            result += variations(currentCount);
        }

        return result;
    }

    private static long variations(long n) {
        return n * (n - 1);
    }

}
