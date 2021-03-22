package y2020.contest.qualify;

import java.io.*;
import java.util.Scanner;

public class Esab {
    private static BufferedReader in = createIn();
    private static BufferedWriter out = createOut();

    private static BufferedWriter createOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader createIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new Esab().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            String result = solveCase(b, scanner);
            out.write(result + "\n");
            out.flush();
            String answer = scanner.next();
            if(answer.equals("N")) {
                return;
            }
        }
    }

    private String solveCase(int b, Scanner scanner) throws IOException {
        int[] result = new int[b];
        int index = 1;
        int[] queries = new int[1];
        int symmetryByteIndex = 0;
        int asymmetryByteIndex = 0;
        int sb = 0;
        int ab = 0;
        while(index <= b/2) {
            if(queries[0] > 0 && queries[0] % 10 == 0) {
                int newSB = 0;
                int newAB = 0;
                if(symmetryByteIndex > 0 && asymmetryByteIndex > 0) {
                    newSB = askByte(symmetryByteIndex, scanner, queries);
                    newAB = askByte(asymmetryByteIndex, scanner, queries);
                    if (newSB == sb) {
                        if (newAB != ab) {
                            transition(result, index);
                        } //else same
                    } else {
                        if (newAB == ab) {
                            transition(result, index);
                            inversion(result, index);
                        } else {
                            inversion(result, index);
                        }
                    }
                } else if(symmetryByteIndex > 0) {
                    newSB = askByte(symmetryByteIndex, scanner, queries);
                    askByte(symmetryByteIndex, scanner, queries);
                    if (newSB != sb) {
                        inversion(result, index);
                    }
                } else if(asymmetryByteIndex > 0) {
                    newAB = askByte(asymmetryByteIndex, scanner, queries);
                    askByte(asymmetryByteIndex, scanner, queries);
                    if(newAB != ab) {
                        transition(result, index);
                    }
                }
                ab = newAB;
                sb = newSB;
            } else {
                //read next two bytes from begin and end
                result[index - 1] = askByte(index, scanner, queries);
                result[b - index] = askByte(b - index + 1, scanner, queries);
                //if read symmetry and have no symmetry -> save symmetry for check
                if(symmetryByteIndex == 0 && result[index - 1] == result[b - index]) {
                    symmetryByteIndex = index;
                    sb = result[index - 1];
                }
                //if read assymetry and have no assymetry -> save assymetry for check
                if(asymmetryByteIndex == 0 && result[index - 1] != result[b - index]) {
                    asymmetryByteIndex = index;
                    ab = result[index - 1];
                }
                index++;
            }
        }
        return formAnswer(result);
    }

    private void inversion(int[] result, int index) {
        for(int i = 0; i < index - 1; i++) {
            result[i] = Math.abs(result[i] - 1);
            result[result.length - i - 1] = Math.abs(result[result.length - i - 1] - 1);
        }
    }
    private void transition(int[] result, int index) {
        for(int i = 0; i < index - 1; i++) {
            int t = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = t;
        }
    }

    private String formAnswer(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int b : result) {
            sb.append(b);
        }
        return sb.toString();
    }

    private int askByte(int i, Scanner scanner, int[] q) throws IOException {
        out.write(i + "\n");
        out.flush();
        q[0]++;
        return scanner.nextInt();
    }
}
