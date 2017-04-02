/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 07.01.15
 * Time: 22:37
 */
package arrayssort;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class InsertionTwo {
    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            move(ar, i);
            printArray(ar);
        }
    }

    private static void move(int[] ar, int i) {
        int value = ar[i];
        int pointer = i;
        while (pointer > 0 && value < ar[pointer - 1]) {
            ar[pointer] = ar[--pointer];
        }
        ar[pointer] = value;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
