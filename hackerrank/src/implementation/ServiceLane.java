/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 23:33
 */
package implementation;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < t; i++) {
            solve(arr, scanner.nextInt(), scanner.nextInt());
        }
    }

    private static void solve(int[] arr, int from, int to) {
        int min = 3;
        for(int i = from; i <= to; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
