package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 0:51.
 */
public class Loops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < 10; i++) {
            int result = n * (i + 1);
            System.out.println(n + " x " + (i + 1) + " = " + result);
        }
    }
}
