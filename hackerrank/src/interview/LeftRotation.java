package interview;

import java.util.Scanner;

/**
 * @author ashevenkov 10.04.17 11:41.
 */
public class LeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        for(int i = 0; i < k; i++) {
            rotate(a);
        }
        return a;
    }

    private static void rotate(int[] a) {
        int first = a[0];
        System.arraycopy(a, 1, a, 0, a.length - 1);
        a[a.length - 1] = first;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
