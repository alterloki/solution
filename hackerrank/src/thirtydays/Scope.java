package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 21:49.
 */
public class Scope {

    static class Difference {
        private int[] elements;
        public int maximumDifference = 0;

        public Difference(int[] a) {
            elements = a;
        }


        public void computeDifference() {
            for (int i = 0; i < elements.length; i++) {
                int element = elements[i];
                for (int j = i + 1; j < elements.length; j++) {
                    int element1 = elements[j];
                    int diff = Math.abs(element - element1);
                    if(diff > maximumDifference) {
                        maximumDifference = diff;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }

}
