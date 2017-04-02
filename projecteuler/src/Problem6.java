/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.02.14
 * Time: 19:52
 */

/**
 * @author ashevenkov
 */
public class Problem6 {

    public static void main(String[] args) {
        long sqSum = 0;
        long sum = 0;
        for(int i = 1; i <= 100; i++) {
            sqSum += i * i;
            sum += i;
        }
        long sumSq = sum * sum;
        long result = sumSq - sqSum;
        System.out.println(result);
    }
}
