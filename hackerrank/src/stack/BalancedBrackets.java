package stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '}' || currentChar == ')' || currentChar == ']') {
                if(stack.size() > 0) {
                    Character previous = stack.peek();
                    if(currentChar == '}' && previous == '{' ||
                            currentChar == ')' && previous == '(' ||
                            currentChar == ']' && previous == '[') {
                        stack.pop();
                    } else {
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            } else {
                stack.push(currentChar);
            }
        }
        if(stack.size() > 0) {
            return "NO";
        } else {
            return "YES";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
