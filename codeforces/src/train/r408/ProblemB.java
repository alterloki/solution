package train.r408;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ashevenkov 05.05.16 19:14.
 */
public class ProblemB {

    public static final String TITLE = "A-large";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("codejam/output/" + TITLE + ".out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("codejam/input/" + TITLE + ".in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


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
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] holes = new boolean[1000001];
        for(int i = 0; i < m; i++) {
            holes[scanner.nextInt()] = true;
        }
        if(holes[1]) {
            out.write("1\n");
            return;
        }
        int position = 1;
        for (int i = 0; i < k; i++) {
            int ui = scanner.nextInt();
            int vi = scanner.nextInt();
            if(ui == position) {
                position = vi;
            } else if(vi == position) {
                position = ui;
            }
            if(holes[position]) {
                out.write(Integer.toString(position) + "\n");
                return;
            }
        }
        out.write(Integer.toString(position) + "\n");
    }

}
