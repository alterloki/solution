package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 05.04.17 13:41.
 */
public class Exceptions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        try {
            int result = Integer.parseInt(s);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
    }
}
