package y2017.contest.qualify;

import java.io.*;
import java.util.*;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemD {

    public static final String TITLE = "D-small-attempt0";
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
        new ProblemD().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n][];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new int[n];
            }
            for(int j = 0; j < m; j++) {
                String symb = scanner.next();
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                switch (symb) {
                    case "+":
                        arr[r - 1][c - 1] = 1;
                        break;
                    case "x":
                        arr[r - 1][c - 1] = 2;
                        break;
                    case "o":
                        arr[r - 1][c - 1] = 3;
                        break;
                    default:
                        arr[r - 1][c - 1] = 0;
                        break;
                }
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(arr));
            out.newLine();
        }
    }

    Map<Integer, Integer> row;
    Map<Integer, Integer> column;
    Map<Integer, Integer> diag1;
    Map<Integer, Integer> diag2;

    private String solveCase(int[][] arr) {
        int[][] oldArr = copy(arr);
        row = new HashMap<>();
        column = new HashMap<>();
        diag1 = new HashMap<>();
        diag2 = new HashMap<>();
        fill(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 0 && plusPossible(i, j)) {
                    setPlus(arr, i, j);
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 0 && xPossible(i, j)) {
                    setX(arr, i, j);
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] > 0 && oPossible(arr, i, j)) {
                    setO(arr, i, j);
                }
            }
        }
        return printResult(arr, oldArr);
    }

    private String printResult(int[][] arr, int[][] oldArr) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                if(arr[i][j] != oldArr[i][j]) {
                    counter++;
                    sb.append(toSymb(arr[i][j]));
                    sb.append(" ");
                    sb.append(i + 1);
                    sb.append(" ");
                    sb.append(j + 1);
                    sb.append("\n");
                }
            }
        }
        String s = sb.toString();
        String result = countScore(arr) + " " + counter;
        if(s.length() > 0) {
            s = s.substring(0, s.length() - 1);
            result = result + "\n" + s;
        }
        return result;
    }

    private String toSymb(int i) {
        if(i == 1) {
            return "+";
        } else if(i == 2) {
            return "x";
        } else if(i == 3) {
            return "o";
        }
        return null;
    }

    private int[][] copy(int[][] arr) {
        int[][] result = new int[arr.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return result;
    }

    private void setO(int[][] arr, int i, int j) {
        arr[i][j] = 3;
        if(arr[i][j] == 1) {
            addToMap(row, i);
            addToMap(column, j);
        }
        if(arr[i][j] == 2) {
            addToMap(diag1, i + j);
            addToMap(diag2, i - j);
        }
    }

    private void setX(int[][] arr, int i, int j) {
        arr[i][j] = 2;
        addToMap(row, i);
        addToMap(column, j);
    }

    private void setPlus(int[][] arr, int i, int j) {
        arr[i][j] = 1;
        addToMap(diag1, i + j);
        addToMap(diag2, i - j);
    }

    private String countScore(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt == 1 || anInt == 2) {
                    result++;
                } else if(anInt == 3) {
                    result += 2;
                }
            }
        }
        return Integer.toString(result);
    }

    private boolean oPossible(int[][] arr, int i, int j) {
        Integer val1 = null;
        Integer val2 = null;
        if(arr[i][j] == 1) {
            val1 = row.get(i);
            val2 = column.get(j);
        }
        if(arr[i][j] == 2) {
            val1 = diag1.get(i + j);
            val2 = diag2.get(i - j);
        }
        return val1 == null && val2 == null;
    }

    private boolean xPossible(int i, int j) {
        Integer val1 = row.get(i);
        Integer val2 = column.get(j);
        return val1 == null && val2 == null;
    }

    private boolean plusPossible(int i, int j) {
        Integer val1 = diag1.get(i + j);
        Integer val2 = diag2.get(i - j);
        return val1 == null && val2 == null;
    }

    private void fill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                int k = ints[j];
                if(k == 2 || k == 3) {
                    addToMap(row, i);
                    addToMap(column, j);
                }
                if(k == 1 || k == 3) {
                    addToMap(diag1, i + j);
                    addToMap(diag2, i - j);
                }
            }
        }
    }

    private void addToMap(Map<Integer, Integer> map, int i) {
        Integer count = map.get(i);
        if(count == null) {
            count = 0;
        }
        map.put(i, count + 1);
    }

}