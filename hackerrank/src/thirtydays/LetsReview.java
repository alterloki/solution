package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 0:54.
 */
public class LetsReview {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            String input = in.next();
            System.out.println(solve(input));
        }
    }

    private static String solve(String input) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                sb1.append(input.charAt(i));
            } else {
                sb2.append(input.charAt(i));
            }
        }
        return sb1.toString() + " " + sb2.toString();
    }
}
