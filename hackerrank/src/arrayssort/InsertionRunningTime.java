/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 07.01.15
 * Time: 23:10
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class InsertionRunningTime {

    public static void insertionSort(int[] A) {
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
            result += i - j - 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);
    }
}
