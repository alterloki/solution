package week31;

import java.util.Scanner;

/**
 * @author ashevenkov 11.04.17 13:24.
 */
public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            if (canSort(a)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean canSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1] && Math.abs(a[i] - a[i + 1]) == 1) {
                swap(a, i, i + 1);
            }
        }
        return checkSorted(a);
    }

    private static void swap(int[] a, int i, int i1) {
        int t = a[i];
        a[i1] = a[i];
        a[i] = t;
    }

    private static boolean checkSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
