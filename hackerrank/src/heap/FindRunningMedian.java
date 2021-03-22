package heap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindRunningMedian {
    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        double[] result = new double[a.length];
        PriorityQueue<Integer> high = new PriorityQueue<>();
        PriorityQueue<Integer> low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int sizeAfter = i + 1;
            if(i == 0) {
                high.add(num);
            } else {
                if(i % 2 == 0) {
                    low.add(num);
                    high.add(low.poll());
                } else {
                    high.add(num);
                    low.add(high.poll());
                }
            }
            if(sizeAfter % 2 == 0) {
                result[i] = ((double)low.peek() + (double)high.peek()) / 2;
            } else {
                result[i] = high.peek();
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

    }
}
