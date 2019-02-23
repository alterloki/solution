package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int[] reverseCount = new int[q.length + 1];
        int result = 0;
        int[] copy = new int[q.length];
        result = sortAndCount(q, reverseCount, copy, 0, q.length);
        boolean tooChaotic = false;
        for (int aReverseCount : reverseCount) {
            if (aReverseCount > 2) {
                tooChaotic = true;
                break;
            }
        }
        if(tooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(result);
        }
    }

    private static int sortAndCount(int[] q, int[] reverseCount, int[] copy, int from, int to) {
        if(to - from == 1) {
            return 0;
        }
        int mergeCount = 0;
        int middle = (from + to) / 2;
        int firstCount = sortAndCount(q, reverseCount, copy, from, middle);
        int secondCount = sortAndCount(q, reverseCount, copy, middle, to);
        int low = from;
        int high = middle;
        int copyIndex = from;
        while(copyIndex < to) {
            if(low >= middle) {
                copy[copyIndex++] = q[high++];
            } else if(high >= to) {
                copy[copyIndex++] = q[low++];
            } else {
                if (q[low] < q[high]) {
                    copy[copyIndex++] = q[low++];
                } else {
                    copy[copyIndex++] = q[high++];
                    for(int i = low; i < middle; i++) {
                        reverseCount[q[i]]++;
                        mergeCount++;
                    }
                }
            }
        }
        System.arraycopy(copy, from, q, from, to - from);
        return firstCount + secondCount + mergeCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
