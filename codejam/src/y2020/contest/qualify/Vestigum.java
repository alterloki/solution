package y2020.contest.qualify;

import y2018.contest.qualify.ProblemA;

import java.io.*;
import java.util.Scanner;

public class Vestigum {

    private static BufferedReader in = createIn();
    private static BufferedWriter out = createOut();

    private static BufferedWriter createOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader createIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new Vestigum().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][];
            for(int j = 0; j < n; j++) {
                matrix[j] = new int[n];
                for(int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int[] result = solveCase(matrix);
            out.write("Case #" + (i + 1) + ": " + result[0] + " " +
                    result[1] + " " + result[2] + "\n");
        }
    }

    private int[] solveCase(int[][] matrix) {
        int sum = 0;
        int r = 0;
        int c = 0;
        //rows
        for(int i = 0; i < matrix.length; i++) {
            int[] counters = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++) {
                int k = matrix[i][j];
                if(counters[k-1] > 0) {
                    r++;
                    break;
                } else {
                    counters[k-1]++;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            int[] counters = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++) {
                int k = matrix[j][i];
                if(counters[k-1] > 0) {
                    c++;
                    break;
                } else {
                    counters[k-1]++;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                int k = matrix[j][i];
                if(i == j) {
                    sum += k;
                }
            }
        }
        return new int[]{sum, r, c};
    }
}
