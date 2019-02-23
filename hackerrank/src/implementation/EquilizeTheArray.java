package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EquilizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int[] index = new int[101];
        for (int anArr : arr) {
            index[anArr]++;
        }
        int max = 0;
        for (int anIndex : index) {
            if (anIndex > max) {
                max = anIndex;
            }
        }
        return arr.length - max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        System.out.println(String.valueOf(result));

        //bufferedWriter.close();

        scanner.close();
    }
}
