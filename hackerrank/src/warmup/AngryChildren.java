/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 29.12.14
 * Time: 0:42
 */
package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ashevenkov
 */
public class AngryChildren {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numPackets = Integer.parseInt(in.readLine());
        int numKids = Integer.parseInt(in.readLine());
        int[] packets = new int[numPackets];

        for (int i = 0; i < numPackets; i++) {
            packets[i] = Integer.parseInt(in.readLine());
        }

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(packets);
        for(int i = 0; i < numPackets - numKids + 1; i++) {
            int delta = packets[i + numKids - 1] - packets[i];
            if(delta < unfairness) {
                unfairness = delta;
            }
        }

        System.out.println(unfairness);
    }
}
