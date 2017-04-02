/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 29.12.14
 * Time: 1:11
 */
package warmup;

import java.util.Scanner;

/**
 * @author ashevenkov
 */
public class ACMICPCTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        byte[][] matrix = new byte[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int topics = knownTopics(matrix[i], matrix[j]);
                if (max < topics) {
                    max = topics;
                    count = 1;
                } else if (max == topics) {
                    count++;
                }
            }
        }
        System.out.println(max);
        System.out.println(count);
    }

    private static int knownTopics(byte[] a, byte[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 || b[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
