/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 05.04.15
 * Time: 22:56
 */
package y2013.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * //TESTED
 * @author ashevenkov
 */
public class ProblemA {

    public static final String TITLE = "A-large-practice";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = prodOut();

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
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            char[][] board = new char[4][];
            for (int j = 0; j < 4; j++) {
                String next = scanner.nextLine();
                board[j] = next.toCharArray();
            }
            if(i < t - 1) {
                scanner.nextLine();
            }
            out.write("Case #" + (i + 1) + ": " + solveBoard(board));
            out.newLine();
        }
    }

    private String solveBoard(char[][] board) {
        boolean owon = isCharWon(board, 'O');
        boolean xwon = isCharWon(board, 'X');
        boolean haveEmpty = isHaveEmpty(board);
        if(owon) {
            return "O won";
        }
        if(xwon) {
            return "X won";
        }
        if(haveEmpty) {
            return "Game has not completed";
        } else {
            return "Draw";
        }
    }

    private boolean isHaveEmpty(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCharWon(char[][] board, char c) {
        boolean cwon = false;
        for (int i = 0; i < 4; i++) {
            if (isFullRow(board, i, c)) {
                cwon = true;
                break;
            }
        }
        if (!cwon) {
            for (int i = 0; i < 4; i++) {
                if (isFullColumn(board, i, c)) {
                    cwon = true;
                    break;
                }
            }
        }
        if (!cwon) {
            int ocount = 0;
            for (int i = 0; i < 4; i++) {
                if (board[i][i] == c || board[i][i] == 'T') {
                    ocount++;
                }
            }
            cwon = ocount == 4;
        }
        if (!cwon) {
            int ocount = 0;
            for (int i = 0; i < 4; i++) {
                if (board[i][3 - i] == c || board[i][3 - i] == 'T') {
                    ocount++;
                }
            }
            cwon = ocount == 4;
        }
        return cwon;
    }

    private boolean isFullColumn(char[][] board, int col, char c) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (board[i][col] == c || board[i][col] == 'T') {
                count++;
            }
        }
        return count == 4;
    }

    private boolean isFullRow(char[][] board, int row, char c) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (board[row][i] == c || board[row][i] == 'T') {
                count++;
            }
        }
        return count == 4;
    }
}
