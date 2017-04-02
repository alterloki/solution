/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.01.15
 * Time: 21:06
 */
package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        if(a.length == 1) {
            return a[0];
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i] != a[i + 1]) {
                    return a[i];
                }
            } else if (i == a.length - 1) {
                if (a[i] != a[i - 1]) {
                    return a[i];
                }
            } else if (a[i] != a[i - 1] && a[i] != a[i + 1]) {
                return a[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }
}
