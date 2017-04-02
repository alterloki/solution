/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 02.01.15
 * Time: 2:16
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class Intro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(v, arr));
    }

    private static int solve(int v, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
