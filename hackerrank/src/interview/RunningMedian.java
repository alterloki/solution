package interview;

import java.util.*;

/**
 * @author ashevenkov 11.04.17 13:47.
 */
public class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        solve(a);
    }

    private static void solve(int[] a) {
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int size = i + 1;
            if (lower.size() == 0) {
                lower.add(num);
            } else {
                if (lower.peek() >= num) {
                    lower.add(num);
                } else {
                    upper.add(num);
                }
            }
            if (upper.size() > size / 2) {
                lower.add(upper.poll());
            }
            if (upper.size() < size / 2) {
                upper.add(lower.poll());
            }
            float result;
            if (size % 2 == 0) {
                result = (float) (upper.peek() + lower.peek()) / 2;
            } else {
                result = lower.peek();
            }

            System.out.printf(Locale.US, "%.1f\n", result);
        }
    }
}
