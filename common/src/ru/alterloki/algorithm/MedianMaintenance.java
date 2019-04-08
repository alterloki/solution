package ru.alterloki.algorithm;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianMaintenance {

    public static final String TITLE = "A-large";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("common/small_kager.out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("common/median.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static BufferedWriter testOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader testIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new MedianMaintenance().solve(in, out);
        out.flush();
        out.close();
    }

    private void solve(BufferedReader in, BufferedWriter out) {
        int result = 0;
        Scanner scanner = new Scanner(in);
        PriorityQueue<Integer> second = new PriorityQueue<>(Integer::compare);
        PriorityQueue<Integer> first = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int count = 0;
        while(scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int median = getMedian(num, first, second, ++count);
            result += median;
            result = result % 10000;
        }
        System.out.println(result);
    }

    private int getMedian(int num, PriorityQueue<Integer> first, PriorityQueue<Integer> second, int count) {
        if(first.size() == 0) {
            first.add(num);
        } else {
            Integer prevMedian = first.peek();
            if(num < prevMedian) {
                first.add(num);
            } else {
                second.add(num);
            }
            if (first.size() > (count + 1) / 2) {
                second.add(first.poll());
            }
            if(second.size() > count / 2) {
                first.add(second.poll());
            }
        }
        return first.peek();
    }
}
