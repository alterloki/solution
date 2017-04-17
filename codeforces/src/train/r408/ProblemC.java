package train.r408;

import java.io.*;
import java.util.*;

/**
 * @author ashevenkov 05.05.16 19:14.
 */
public class ProblemC {

    public static final String TITLE = "A-large";
    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("codejam/output/" + TITLE + ".out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("codejam/input/" + TITLE + ".in"));
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
        new ProblemC().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        Map<Integer, Set<Integer>> connections = new HashMap<>();
        int[] defences = new int[n];
        for(int i = 0; i < n; i++) {
            defences[i] = scanner.nextInt();
        }
        for(int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            addConnection(connections, a, b);
            addConnection(connections, b, a);
        }
        out.write(Integer.toString(solve(n, defences, connections)) + "\n");
    }

    private int solve(int n, int[] defences, Map<Integer, Set<Integer>> connections) {
        int maxIndex = 0;
        int maxValue = defences[0];
        for (int i = 0; i < defences.length; i++) {
            int defence = defences[i];
            if(defence > maxValue) {
                maxIndex = i;
            }
        }
        int maxAmount = maxValue;
        while(!connections.isEmpty()) {

        }
        return 0;
    }

    private void addConnection(Map<Integer, Set<Integer>> connections, int a, int b) {
        Set<Integer> set = connections.get(a);
        if(set == null) {
            set = new HashSet<>();
            connections.put(a, set);
        }
        set.add(b);
    }

}
