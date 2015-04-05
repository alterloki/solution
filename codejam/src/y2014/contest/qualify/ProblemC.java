/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 02.04.15
 * Time: 0:02
 */
package y2014.contest.qualify;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemC {

    private static BufferedWriter bw;

    //fill and cut
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("codejam/input/C-large-practice.in"));
        //Scanner scanner = new Scanner(System.in);
        bw = new BufferedWriter(new FileWriter("codejam/output/C-large-practice.out"));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] result = new ProblemC().solve(r, c, m);
            println("Case #" + (i + 1) + ":");
            if (result == null) {
                println("Impossible");
            } else {
                for (int j = 0; j < result.length; j++) {
                    println(new String(result[j]));
                }
            }
        }
        bw.close();
    }

    private static void println(String s) throws IOException {
        //System.out.println(s);
        bw.write(s);
        bw.newLine();
    }

    private char[][] solve(int r, int c, int m) {
        char[][] board = createBoard(r, c);
        if (m == 0) {
            board[0][0] = 'c';
            return board;
        }
        if (c == 1) {
            for (int i = 0; i < m; i++) {
                board[i][0] = '*';
            }
            board[r - 1][0] = 'c';
            return board;
        }
        if (r == 1) {
            for (int i = 0; i < m; i++) {
                board[0][i] = '*';
            }
            board[0][c - 1] = 'c';
            return board;
        }
        int free = r * c - m;
        if (free == 2 || free == 3) {
            return null;
        }
        if (free == 1) {
            for (int i = 0; i < m; i++) {
                board[i / c][i % c] = '*';
            }
            board[r - 1][c - 1] = 'c';
            return board;
        }
        if (c == 2) {
            if (m % 2 == 0) {
                for (int i = 0; i < m / 2; i++) {
                    board[i][0] = '*';
                    board[i][1] = '*';
                }
                board[r - 1][c - 1] = 'c';
                return board;
            } else {
                return null;
            }
        }
        if (r == 2) {
            if (m % 2 == 0) {
                for (int i = 0; i < m / 2; i++) {
                    board[0][i] = '*';
                    board[1][i] = '*';
                }
                board[r - 1][c - 1] = 'c';
                return board;
            } else {
                return null;
            }
        }
        int border = c * (r - 3);
        if (free >= 3 * c) {
            for (int i = 0; i < m; i++) {
                board[i / c][i % c] = '*';
            }
            if ((m - 1) % c == c - 2) {
                board[(m - 1) / c][(m - 1) % c] = '.';
                board[(m - 1) / c + 1][0] = '*';
            }
            board[r - 1][c - 1] = 'c';
        } else if (free >= 9) {
            for (int i = 0; i < border; i++) {
                board[i / c][i % c] = '*';
            }
            for (int i = border; i < m; i++) {
                int row = r - 3 + (i - border) % 3;
                int column = (i - border) / 3;
                board[row][column] = '*';
            }
            if ((m - 1 - border) % 3 == 1) {
                board[r - 3][(m - 1 - border) / 3 + 1] = '*';
                board[r - 2][(m - 1 - border) / 3] = '.';
            }
            board[r - 1][c - 1] = 'c';
        } else {
            if (free != 7 && free != 5) {
                for (int i = 0; i < border; i++) {
                    board[i / c][i % c] = '*';
                }
                for (int i = border; i < c * r - 9; i++) {
                    int row = r - 3 + (i - border) % 3;
                    int column = (i - border) / 3;
                    board[row][column] = '*';
                }
                if (free <= 8) {
                    board[r - 3][c - 3] = '*';
                }
                if (free <= 6) {
                    board[r - 2][c - 3] = '*';
                    board[r - 1][c - 3] = '*';
                }
                if (free <= 4) {
                    board[r - 3][c - 2] = '*';
                    board[r - 3][c - 1] = '*';
                }
                board[r - 1][c - 1] = 'c';
            } else {
                return null;
            }
        }
        return board;
    }

    private char[][] createBoard(int r, int c) {
        char[][] result = new char[r][c];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], '.');
        }
        return result;
    }

}
