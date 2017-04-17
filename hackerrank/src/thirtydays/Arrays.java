package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 0:56.
 */
public class Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if(i > 0) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        in.close();
    }
}
