/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 29.12.14
 * Time: 1:46
 */
package warmup;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class FillingJars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[] a = new int[m];
        int[] b = new int[m];
        int[] k = new int[m];
        for(int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().split(" ");
            a[i] = Integer.parseInt(split[0]);
            b[i] = Integer.parseInt(split[1]);
            k[i] = Integer.parseInt(split[2]);
        }
        double avg = 0;
        for (int i = 0; i < m; i++) {
            double part = (double)k[i] / n * (b[i] - a[i] + 1);
            avg += part;
        }
        long result = (long) Math.floor(avg);
        System.out.println(result);
    }
}
