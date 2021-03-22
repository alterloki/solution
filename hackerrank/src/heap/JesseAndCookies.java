package heap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : A) {
            pq.add(num);
        }
        int result = 0;
        while(pq.peek() < k) {
            if(pq.size() < 2) {
                return -1;
            } else {
                pq.add(pq.poll() + 2 * pq.poll());
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] A = new int[n];
        int i = 0;
        while(i < n) {
            A[i++] = scanner.nextInt();
        }
        int result = cookies(k, A);
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.close();
    }
}
