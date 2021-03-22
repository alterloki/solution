package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class QHeap1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int q = Integer.parseInt(line);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < q; i++) {
            line = br.readLine();
            String[] parts = line.split(" ");
            if(parts[0].equals("1")) {
                 int v = Integer.parseInt(parts[1]);
                heap.add(v);
            } else if(parts[0].equals("2")) {
                int v = Integer.parseInt(parts[1]);
                heap.remove(v);
            } else if(parts[0].equals("3")) {
                System.out.println(heap.peek());
            }
        }
        br.close();
    }
}
