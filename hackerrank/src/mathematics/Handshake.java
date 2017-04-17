package mathematics;

import java.util.Scanner;

/**
 * @author ashevenkov 18.04.17 0:37.
 */
public class Handshake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int N = in.nextInt();
            int n = N - 1;
            int result = n * (n + 1) / 2;
            System.out.println(result);
        }
    }
}
