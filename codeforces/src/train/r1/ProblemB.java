package train.r1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * //TESTED
 * @author ashevenkov 05.05.16 11:51.
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
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solveCase(s));
        }
    }

    private String solveCase(String s) {
        Pattern pattern = Pattern.compile("R([\\d]+)C([\\d]+)");
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()) {
            String row = matcher.group(1);
            String column = matcher.group(2);
            return toNumString(row, column);
        } else {
            pattern = Pattern.compile("([\\p{Upper}]+)([\\d]+)");
            matcher = pattern.matcher(s);
            if (matcher.matches()) {
                String column = matcher.group(1);
                String row = matcher.group(2);
                return toStringNum(column, row);
            }
        }
        return "";
    }

    private String toStringNum(String column, String row) {
        return "R" + row + "C" + columnToNumber(column);
    }

    private int columnToNumber(String column) {
        int result = 0;
        for (int i = 0; i < column.toCharArray().length; i++) {
            char c = column.toCharArray()[i];
            result *= 26;
            result += (c - 'A' + 1);
        }
        return result;
    }

    private String toNumString(String row, String column) {
        int iRow = Integer.parseInt(row);
        int iColumn = Integer.parseInt(column);
        return columnToString(iColumn) + iRow;
    }

    private String columnToString(int iColumn) {
        StringBuilder sb = new StringBuilder();
        while(iColumn > 0) {
            iColumn--;
            char c = (char) ('A' + (iColumn % 26));
            iColumn -= (iColumn % 26);
            iColumn /= 26;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
