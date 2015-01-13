/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 23:26
 */
package implementation;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class SherlockArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(solve(arr));
        }
    }

    private static String solve(int[] arr) {
        int before = 0;
        int after = sumAllMinusFirst(arr);
        if(before == after) {
            return "YES";
        }
        for (int i = 0; i < arr.length- 1; i++) {
            int value = arr[i];
            int nextVal = arr[i + 1];
            before += value;
            after -= nextVal;
            if(before == after) {
                return "YES";
            }
        }
        return "NO";
    }

    private static int sumAllMinusFirst(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
