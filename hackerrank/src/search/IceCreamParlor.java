/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 21:15
 */
package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            solve(m, arr);
        }
    }

    private static void solve(int m, int[] arr) {
        int[] index = new int[10001];
        Arrays.fill(index, -1);
        for (int i = 0; i < arr.length; i++) {
            index[arr[i]] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int second = m - arr[i];
            if(second > 0 && index[second] > 0 && i != index[second]) {
                System.out.println(Math.min(i + 1, index[second] + 1) + " " + Math.max(i + 1, index[second] + 1));
                break;
            }
        }
    }
}
