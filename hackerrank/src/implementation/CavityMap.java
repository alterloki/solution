/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 10.01.15
 * Time: 22:53
 */
package implementation;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class CavityMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            char[] ca = line.toCharArray();
            for (int j = 0; j < ca.length; j++) {
                char c = ca[j];
                arr[i][j] = c - '0';
            }
        }
        printCavities(arr);
    }

    private static void printCavities(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int[] line = arr[i];
            for (int j = 0; j < line.length; j++) {
                if(isCavity(arr, i, j)) {
                    System.out.print("X");
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println("");
        }
    }

    private static boolean isCavity(int[][] arr, int i, int j) {
        if(i > 0 && j > 0 && i < arr.length - 1 && j < arr.length - 1) {
            int value = arr[i][j];
            if(arr[i - 1][j] < value && arr[i][j - 1] < value && arr[i][j + 1] < value && arr[i + 1][j] < value) {
                return true;
            }
        }
        return false;
    }
}
