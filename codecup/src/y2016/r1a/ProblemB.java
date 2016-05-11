package y2016.r1a;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov
 */
public class ProblemB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int[] lenVag = new int[n];
            int[] on = new int[n];
            for(int j = 0; j < n; j++) {
                lenVag[j] = scanner.nextInt();
            }
            for(int j = 0; j < n; j++) {
                on[j] = scanner.nextInt();
            }
            System.out.println(solve(n, h, lenVag, on));
        }
    }

    private static String solve(int n, int h, int[] lenVag, int[] on) {
        long offLen = 0;
        int toOn = 0;
        if(on[0] == 0) {
            on[0] = 1;
            toOn++;
        }
        for (int i = 0; i < lenVag.length; i++) {
            //first
            if(on[i] == 0) {
                offLen += lenVag[i];
            } else {
                offLen = 0;
            }
            if(offLen >= h) {
                on[i] = 1;
                toOn++;
                offLen = 0;
            }
        }
        //last
        if(on[on.length - 1] == 0) {
            toOn++;
        }
        return Integer.toString(toOn);
    }

}
