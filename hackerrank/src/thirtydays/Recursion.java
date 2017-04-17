package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 17:40.
 */
public class Recursion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.next());
        System.out.println(new Recursion().f(k));
    }

    private int f(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * f(n - 1);
    }
}
