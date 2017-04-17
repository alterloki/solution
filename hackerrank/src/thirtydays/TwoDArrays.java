package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 18:53.
 */
public class TwoDArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 4; y++) {
                int h = hourglass(arr, x, y);
                if(h > max) {
                    max = h;
                }
            }
        }
        System.out.println(max);
    }

    private static int hourglass(int[][] arr, int i, int j) {
        int sum = 0;
        for(int x = 0; x < 3; x++) {
            sum += arr[i][x + j];
            sum += arr[i + 2][x + j];
        }
        sum += arr[i + 1][j + 1];
        return sum;
    }

}
