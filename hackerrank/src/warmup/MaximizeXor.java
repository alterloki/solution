/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.12.14
 * Time: 2:10
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class MaximizeXor {

    static int maxXor(int l, int r) {
        int result = 0;
        for(int i = l; i < r; i++) {
            for(int j = i + 1; j <= r; j++) {
                int x = i ^ j;
                if(x > result) {
                    result = x;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
