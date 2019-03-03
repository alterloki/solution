package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = solve(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if(i < result.length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }

        }

        scanner.close();
    }

    private static int[] solve(int[] a, int d) {
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            int index = i - d < 0 ? a.length + i - d : i - d;
            result[index] = a[i];
        }
        return result;
    }
}
