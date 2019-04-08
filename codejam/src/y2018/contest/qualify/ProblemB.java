package y2018.contest.qualify;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemB {

    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter testOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader testIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new ProblemB().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] list = new int[n];
            for (int j = 0; j < list.length; j++) {
                list[j] = scanner.nextInt();
            }
            int result = solveCase(n, list);
            if(result >= 0) {
                out.write("Case #" + (i + 1) + ": " + result + "\n");
            } else {
                out.write("Case #" + (i + 1) + ": OK\n");
            }
        }
    }

    private int solveCase(int n, int[] list) {
        int[] list1 = new int[(n + 1) / 2];
        int[] list2 = new int[n / 2];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = list[2 * i];
        }
        for (int i = 0; i < list2.length; i++) {
            list2[i] = list[2 * i + 1];

        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < list1.length; i++) {
            list[2 * i] = list1[i];
        }
        for (int i = 0; i < list2.length; i++) {
            list[2 * i + 1] = list2[i];
        }
        int index = -1;
        for (int i = 0; i < list.length - 1; i++) {
            if(list[i] > list[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }

}
