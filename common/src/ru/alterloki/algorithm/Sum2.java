package ru.alterloki.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sum2 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("common/_6ec67df2804ff4b58ab21c12edcb21f8_algo1-programming_prob-2sum.txt")));
        long[] values = new long[1000000];
        Set<Long> set = new HashSet<>();
        int counter = 0;
        while(scanner.hasNextLong()) {
            values[counter] = scanner.nextLong();
            set.add(values[counter++]);
        }
        int result = 0;
        for(int i = -10000; i <= 10000; i++) {
            for (int j = 0; j < values.length; j++) {
                long value = values[j];
                long tryValue = i - value;
                if(value != tryValue && set.contains(tryValue)) {
                    result++;
                    break;
                }
            }
            System.out.println(i);
        }
        System.out.println(result);
    }
}
