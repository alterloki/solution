/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 22:44
 */

import ru.alterloki.Util;

/**
 * @author ashevenkov
 */
public class Problem1 {

    public static void main(String[] args) {
        int result = 0;
        for(int i = 1; i < 1000; i++) {
            if(Util.isMultiple(i, 3) || Util.isMultiple(i, 5))  {
                result+=i;
            }
        }
        System.out.println(result);
    }
}
