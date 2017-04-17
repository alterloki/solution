package mathematics;

import java.util.Scanner;

/**
 * @author ashevenkov 10.04.17 10:56.
 */
public class ConnectingTowns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] routes = new int[n - 1];
            for(int j = 0; j < n - 1; j++) {
                routes[j] = scanner.nextInt();
            }
            System.out.println(solve(routes));
        }
    }

    private static String solve(int[] routes) {
        int result = 1;
        for (int route : routes) {
            result = (result * route) % 1234567;
        }
        return Integer.toString(result);
    }
}
