package thirtydays;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author ashevenkov 08.04.17 20:55.
 */
public class Testing {

    public static void main(String[] args) {
        System.out.println("5");
        int[] ns = generateN();
        printYes(ns[0]);
        printNo(ns[1]);
        printYes(ns[2]);
        printNo(ns[3]);
        printYes(ns[4]);
    }

    private static void printNo(int n) {
        Random rnd = new Random();
        int k = rnd.nextInt(n - 2) + 2;
        System.out.println(n + " " + k);
        StringBuilder sb = new StringBuilder();
        sb.append("0 ");
        int before = k + rnd.nextInt(n - k - 1);
        for(int i = 0; i < before; i++) {
            int time = rnd.nextInt(1000);
            sb.append(-time);
            sb.append(" ");
        }
        int after = n - before - 1;
        for(int i = 0; i < after; i++) {
            int time = rnd.nextInt(1000);
            sb.append(time);
            if(i < after - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void printYes(int n) {
        Random rnd = new Random();
        int k = rnd.nextInt(n - 2) + 2;
        System.out.println(n + " " + k);
        StringBuilder sb = new StringBuilder();
        sb.append("0 ");
        int before = rnd.nextInt(k - 1);
        for(int i = 0; i < before; i++) {
            int time = rnd.nextInt(1000);
            sb.append(-time);
            sb.append(" ");
        }
        int after = n - before - 1;
        for(int i = 0; i < after; i++) {
            int time = rnd.nextInt(1000);
            sb.append(time);
            if(i < after - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static int[] generateN() {
        Random rnd = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int n = rnd.nextInt(200);
            if (n >= 3) {
                set.add(n);
            }
        }
        return toInt(set);
    }

    public static int[] toInt(Set<Integer> set) {
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer val : set) a[i++] = val;
        return a;
    }

}
