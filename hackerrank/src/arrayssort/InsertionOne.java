/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 03.01.15
 * Time: 1:42
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class InsertionOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(arr);
    }

    private static void solve(int[] ar) {
        int value = ar[ar.length - 1];
        int pointer = ar.length - 1;
        while(pointer > 0 && value < ar[pointer - 1]) {
            ar[pointer] = ar[--pointer];
            printArray(ar);
        }
        ar[pointer] = value;
        printArray(ar);
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i > 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
