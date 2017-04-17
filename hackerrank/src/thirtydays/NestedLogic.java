package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 20:36.
 */
public class NestedLogic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int da = scanner.nextInt();
        int ma = scanner.nextInt();
        int ya = scanner.nextInt();
        int de = scanner.nextInt();
        int me = scanner.nextInt();
        int ye = scanner.nextInt();
        System.out.println(solve(da, ma, ya, de, me, ye));
    }

    private static int solve(int da, int ma, int ya, int de, int me, int ye) {
        if(ya < ye) {
            return 0;
        } else if(ya == ye) {
            if(ma < me) {
                return 0;
            } else if(ma == me) {
                if(da <= de) {
                    return 0;
                } else {
                    return 15 * (da - de);
                }
            } else {
                return 500 * (ma - me);
            }
        } else {
            return 10000;
        }
    }
}
