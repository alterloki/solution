/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 07.01.15
 * Time: 23:26
 */
package arrayssort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class QuickOne {

    static void partition(int[] ar) {
        int valueCount = 0;
        int value = ar[0];
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            int a = ar[i];
            if(a < value) {
                less.add(a);
            } else if(a > value) {
                more.add(a);
            } else {
                valueCount++;
            }
        }

        int[] result = new int[ar.length];
        for(int i = 0; i < less.size(); i++) {
            result[i] = less.get(i);
        }
        for(int i = less.size(); i < less.size() + valueCount; i++) {
            result[i] = value;
        }
        for(int i = 0; i < more.size(); i++) {
            result[i + less.size() + valueCount] = more.get(i);
        }
        printArray(result);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
    }
}
