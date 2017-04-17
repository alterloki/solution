package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 18:33.
 */
public class BinaryNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 0) {
            System.out.println(0);
        }
        int result = 0;
        int counter = 0;
        while(n > 0) {
            int b = n & 1;
            if(b == 1) {
                counter++;
            } else {
                if(counter > result) {
                    result = counter;
                }
                counter = 0;
            }
            n = n >> 1;
        }
        if(counter > result) {
            result = counter;
        }
        System.out.println(result);
    }

}
