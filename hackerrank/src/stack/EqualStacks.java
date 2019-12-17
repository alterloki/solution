package stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer>[] stacks = new Stack[3];
        stacks[0] = toStack(h1);
        stacks[1] = toStack(h2);
        stacks[2] = toStack(h3);
        while (!stacks[0].peek().equals(stacks[1].peek()) || !stacks[1].peek().equals(stacks[2].peek())) {
            int maxIndex = getMaxIndex(stacks);
            stacks[maxIndex].pop();
        }
        return stacks[0].peek();
    }

    private static int getMaxIndex(Stack<Integer>[] stacks) {
        if(stacks[0].peek() >= stacks[1].peek() && stacks[0].peek() >= stacks[2].peek()) {
            return 0;
        }
        if(stacks[1].peek() >= stacks[0].peek() && stacks[1].peek() >= stacks[2].peek()) {
            return 1;
        }
        if(stacks[2].peek() >= stacks[1].peek() && stacks[2].peek() >= stacks[0].peek()) {
            return 2;
        }
        return -1;
    }

    private static Stack<Integer> toStack(int[] h1) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = h1.length - 1; i >= 0; i--) {
            stack.push(sum);
            sum += h1[i];
        }
        stack.push(sum);
        return stack;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
