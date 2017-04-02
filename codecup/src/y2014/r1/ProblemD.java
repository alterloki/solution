/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.04.14
 * Time: 19:24
 */
package y2014.r1;

import java.io.*;

/**
 * @author ashevenkov
 */
public class ProblemD {

    private static String INPUT =
            "2 3\n" +
            "B..\n" +
            "..G";

        public static void main(String[] args) throws IOException {
            new ProblemC().fire(new StringBufferInputStream(INPUT));
            //new y2015.r1.ProblemC().fire(System.in);
        }

        public void fire(InputStream is) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                int n = Integer.parseInt(line);
                line = br.readLine();
                String[] parts = line.split(" ");
                int[] v = new int[n];
                for (int j = 0; j < parts.length; j++) {
                    String part = parts[j];
                    v[j] = Integer.parseInt(part);
                }
                System.out.println(solve(v));
            }
        }

    private boolean solve(int[] v) {
        return false;
    }
}
