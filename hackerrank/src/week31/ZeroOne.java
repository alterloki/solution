package week31;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashevenkov 12.04.17 15:28.
 */
public class ZeroOne {


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int[] sequence = new int[n];
            for (int sequence_i = 0; sequence_i < n; sequence_i++) {
                sequence[sequence_i] = in.nextInt();
            }
            new ZeroOne().solve(sequence);
        }
    }

    private void solve(int[] sequence) {
        int starCount = 0;
        int size = sequence.length;
        while (true) {
            int[] sequenceTmp = new int[size];
            int tmpI = 0;
            int currentStars = 0;
            for (int i = 0; i < size; i++) {
                if (i > 0 && i < size - 1 && sequence[i - 1] == 0 && sequence[i + 1] == 0) {
                    currentStars++;
                } else {
                    sequenceTmp[tmpI++] = sequence[i];
                }
            }
            if(currentStars == 0) {
                break;
            } else {
                starCount += currentStars;
            }
            sequence = sequenceTmp;
            size = tmpI;
        }
        if(starCount % 2 == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }

}
