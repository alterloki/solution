package y2018.contest.qualify;

import java.io.*;
import java.util.Scanner;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemA {

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
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            int d = scanner.nextInt();
            String pString = scanner.next();
            int result = solveCase(d, toIntArray(pString));
            if(result == -1) {
                out.write("Case #" + (i + 1) + ": IMPOSSIBLE\n");
            } else {
                out.write("Case #" + (i + 1) + ": " + result + "\n");
            }
        }
    }

    private int solveCase(int d, int[] program) {
        int currentScore = countScore(program);
        int result = 0;
        while(currentScore > d) {
            int preZeroes = 0;
            int zeroes = 0;
            int index = -1;
            for (int i = 0; i < program.length - 1; i++) {
                if(program[i] == 0 && program[i + 1] == 1) {
                    index = i;
                    preZeroes = zeroes;
                }
                if(program[i] == 0) {
                    zeroes++;
                }
            }
            if(index >= 0) {
                program[index] = 1;
                program[index + 1] = 0;
                currentScore -= Math.pow(2, preZeroes);
                result++;
            } else {
                return -1;
            }
        }
        return result;
    }

    private int countScore(int[] program) {
        int sumScore = 0;
        int curStrength = 1;
        for (int i : program) {
            if(i == 1) {
                sumScore += curStrength;
            } else {
                curStrength *= 2;
            }
        }
        return sumScore;
    }

    private int[] toIntArray(String pString) {
        int[] result = new int[pString.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pString.charAt(i) == 'C' ? 0 : 1;
        }
        return result;
    }

}
