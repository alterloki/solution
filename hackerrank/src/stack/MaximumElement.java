package stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] commands = new int[n][];
        for(int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            commands[i] = new int[2];
            if(type == 1) {
                int x = scanner.nextInt();
                commands[i][0] = 1;
                commands[i][1] = x;
            } else if(type == 2) {
                commands[i][0] = 2;
            } else {
                commands[i][0] = 3;
            }
        }
        calculate(commands);
    }

    private static void calculate(int[][] commands) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max = new Stack<>();
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            if(command[0] == 1) {
                //push
                int x = command[1];
                stack.push(x);
                if(max.size() == 0) {
                    max.push(x);
                } else {
                    Integer prevMax = max.peek();
                    if(prevMax < x) {
                        max.push(x);
                    } else {
                        max.push(prevMax);
                    }
                }
            } else if(command[0] == 2) {
                stack.pop();
                max.pop();
            } else {
                System.out.println(max.peek());
            }
        }
    }
}
