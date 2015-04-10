/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 08.04.15
 * Time: 20:21
 */
package y2013.contest.qualify;

import java.io.*;
import java.util.*;

/**
 * TESTED
 * @author ashevenkov
 */
public class ProblemD {
    public static final String TITLE = "D-large-practice";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = prodOut();

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
        new ProblemD().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            ArrayList<Integer> keys = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                keys.add(scanner.nextInt());
            }
            int[] keyType = new int[n];
            int[][] keysInside = new int[n][];
            for (int j = 0; j < n; j++) {
                keyType[j] = scanner.nextInt();
                int ki = scanner.nextInt();
                keysInside[j] = new int[ki];
                for (int m = 0; m < ki; m++) {
                    keysInside[j][m] = scanner.nextInt();
                }
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(keys, keyType, keysInside));
            out.newLine();
        }
    }

    private String solveCase(ArrayList<Integer> startKeys, int[] keyType, int[][] keysInside) {
        int[] keysInHand = new int[400];
        for (Integer startKey : startKeys) {
            keysInHand[startKey]++;
        }
        boolean opened[] = new boolean[keyType.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < keyType.length; i++) {
            boolean wasOpened = false;
            for (int j = 0; j < keyType.length; j++) {
                if (keysInHand[keyType[j]] > 0 && !opened[j]) {
                    keysInHand[keyType[j]]--;
                    opened[j] = true;
                    addKeys(keysInHand, keysInside[j]);
                    if (checkOpened(keyType, opened, keysInHand, keysInside)) {
                        result.add(j);
                        wasOpened = true;
                        break;
                    } else {
                        keysInHand[keyType[j]]++;
                        opened[j] = false;
                        removeKeys(keysInHand, keysInside[j]);
                    }
                }
            }
            if (!wasOpened) {
                return "IMPOSSIBLE";
            }
        }
        return resultToString(result);
    }

    private void removeKeys(int[] keysInHand, int[] keysInChest) {
        for (int i = 0; i < keysInChest.length; i++) {
            int keyInChest = keysInChest[i];
            keysInHand[keyInChest]--;
        }
    }

    private void addKeys(int[] keysInHand, int[] keysInChest) {
        for (int i = 0; i < keysInChest.length; i++) {
            int keyInChest = keysInChest[i];
            keysInHand[keyInChest]++;
        }
    }

    private boolean checkOpened(int[] keyType, boolean[] opened, int[] keysInHand, int[][] keysInside) {
        Map<Integer, List<Integer>> key2chests = new HashMap<>();
        for (int i = 0; i < keyType.length; i++) {
            List<Integer> chestList = key2chests.get(keyType[i]);
            if (chestList == null) {
                chestList = new ArrayList<>();
                key2chests.put(keyType[i], chestList);
            }
            chestList.add(i);
        }
        boolean[] copen = Arrays.copyOf(opened, opened.length);
        int closed = 0;
        for (int i = 0; i < copen.length; i++) {
            if (!copen[i]) {
                closed++;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < copen.length; i++) {
            if (!copen[i]) {
                if (keysInHand[keyType[i]] > 0) {
                    stack.add(i);
                    closed--;
                    copen[i] = true;
                }
            }
        }
        while (!stack.isEmpty() && closed > 0) {
            Integer chest = stack.pop();
            int[] chestKeys = keysInside[chest];
            for (int i = 0; i < chestKeys.length; i++) {
                int chestKey = chestKeys[i];
                List<Integer> chests = key2chests.get(chestKey);
                if (chests != null) {
                    for (Integer chestId : chests) {
                        if (!copen[chestId]) {
                            stack.add(chestId);
                            closed--;
                            copen[chestId] = true;
                        }
                    }
                }
            }
        }
        if (closed == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String resultToString(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Integer i : result) {
            if (counter > 0) {
                sb.append(" ");
            }
            sb.append(i + 1);
            counter++;
        }
        return sb.toString();
    }
}
