package mathematics;

import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 22:35.
 */
public class Restaurant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int b = scanner.nextInt();
            int maxSide = solve(l, b);
            int result = l / maxSide * b / maxSide;
            System.out.println(result);
        }
    }

    private static int solve(int l, int b) {
        if(l > b) {
            return nod(l, b);
        } else {
            return nod(b, l);
        }
    }

    private static int nod(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        } else {
            return nod(b, r);
        }
    }
}
