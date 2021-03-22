package y2020.contest.qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Parenting {
    private static BufferedReader in = createIn();
    private static BufferedWriter out = createOut();

    private static BufferedWriter createOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader createIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new Parenting().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            int[][] periods = new int[n][];
            for(int j = 0; j < n; j++) {
                int b = scanner.nextInt();
                int e = scanner.nextInt();
                periods[j] = new int[]{b, e};
            }
            String result = solveCase(periods);
            out.write("Case #" + (i + 1) + ": " + result + "\n");
        }
    }

    private String solveCase(int[][] periods) {
        List<Set<Integer>> minutes = new ArrayList<>();
        for (int i = 0; i < 60 * 24; i++) {
            minutes.add(new HashSet<>());
        }
        for (int i = 0; i < periods.length; i++) {
            int[] period = periods[i];
            for (int j = period[0]; j < period[1]; j++) {
                minutes.get(j).add(i);
            }
        }
        char[] participation = new char[periods.length];
        for (int i = 0; i < 60 * 24; i++) {
            HashSet<Integer> periodJobs = new HashSet<>(minutes.get(i));
            if (periodJobs.size() > 2) {
                return "IMPOSSIBLE";
            } else {
                boolean cBusy = false;
                boolean jBusy = false;
                for (Integer job : periodJobs) {
                    if (participation[job] == 'C') {
                        cBusy = true;
                    }
                    if (participation[job] == 'J') {
                        jBusy = true;
                    }
                }
                for (Integer job : periodJobs) {
                    if (participation[job] == 0) {
                        if (!cBusy) {
                            participation[job] = 'C';
                            cBusy = true;
                        } else if (!jBusy) {
                            participation[job] = 'J';
                            jBusy = true;
                        }
                    }
                }
            }
        }
        return new String(participation);
    }
}