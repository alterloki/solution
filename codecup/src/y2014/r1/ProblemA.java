package y2014.r1;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.04.14
 * Time: 11:37
 */
public class ProblemA {

    public static void main(String[] args) throws IOException {
        new ProblemA().fire(System.in);
    }

    private void fire(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            int n = Integer.parseInt(line.trim());
            int[][] field = new int[n][];
            int[][] revField = new int[n][];
            for (int j = 0; j < n; j++) {
                revField[j] = new int[n];
            }
            for (int j = 0; j < n; j++) {
                line = br.readLine();
                String[] parts = line.split(" ");
                field[j] = new int[n];
                for (int k = 0; k < parts.length; k++) {
                    String part = parts[k];
                    field[j][k] = Integer.parseInt(part);
                    revField[k][j] = Integer.parseInt(part);
                }
            }
            System.out.println(solve(n, field, revField));
        }
    }

    private String solve(int n, int[][] field, int[][] revField) {
        //rows and empty
            for (int i = 0; i < field.length; i++) {
            int[] row = field[i];
            int[] column = revField[i];
            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                if(num == 0) {
                    return "YES";
                }
                if(j > 0) {
                    if(row[j] == row[j - 1]) {
                        return "YES";
                    }
                    if(column[j] == column[j - 1]) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
}
