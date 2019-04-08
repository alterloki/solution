package trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SwapNodes {
    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            result[i] = new int[indexes.length];
            int query = queries[i];
            bfs(indexes, 1,  1, query);
            inOrder(indexes, result[i], 1, new int[1]);
        }
        return result;
    }

    private static void inOrder(int[][] indexes, int[] result, int root, int[] ind) {
        if(indexes[root - 1][0] > 0) {
            inOrder(indexes, result, indexes[root - 1][0], ind);
        }
        result[ind[0]++] = root;
        if(indexes[root - 1][1] > 0) {
            inOrder(indexes, result, indexes[root - 1][1], ind);
        }
    }

    private static void bfs(int[][] indexes, int node, int level, int query) {
        if(level % query == 0) {
            int t = indexes[node - 1][0];
            indexes[node - 1][0] = indexes[node - 1][1];
            indexes[node - 1][1] = t;
        }
        if(indexes[node - 1][0] > 0) {
            bfs(indexes, indexes[node - 1][0],level + 1, query);
        }
        if(indexes[node - 1][1] > 0) {
            bfs(indexes, indexes[node - 1][1],level + 1, query);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
