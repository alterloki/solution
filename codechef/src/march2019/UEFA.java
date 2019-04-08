package march2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UEFA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line != null) {
            int t = Integer.parseInt(line);
            String[][] teams = new String[t][];
            for (int i = 0; i < t; i++) {
                Map<String, Map<String, int[]>> results = new HashMap<>();
                for (int j = 0; j < 12; j++) {
                    line = br.readLine();
                    String[] parts = line.split(" ");
                    String teamA = parts[0];
                    int scoreA = Integer.parseInt(parts[1]);
                    int scoreB = Integer.parseInt(parts[3]);
                    String teamB = parts[4];
                    Map<String, int[]> pairMap = results.computeIfAbsent(teamA, k -> new HashMap<>());
                    pairMap.put(teamB, new int[]{scoreA, scoreB});
                }
                teams[i] = solve(results);
            }
            for (String[] team : teams) {
                System.out.println(team[0] + " " + team[1]);
            }
        }
        br.close();
    }

    private static String[] solve(Map<String, Map<String, int[]>> results) {
        Map<String, Integer> scores = new HashMap<>();
        Map<String, Integer> goals = new HashMap<>();
        for (Map.Entry<String, Map<String, int[]>> entry : results.entrySet()) {
            String teamA = entry.getKey();
            Map<String, int[]> map = entry.getValue();
            for (Map.Entry<String, int[]> innerEntry : map.entrySet()) {
                String teamB = innerEntry.getKey();
                int[] matchScore = innerEntry.getValue();
                if(matchScore[0] > matchScore[1]) {
                    scores.put(teamA, scores.computeIfAbsent(teamA, k -> 0) + 3);
                    scores.put(teamB, scores.computeIfAbsent(teamB, k -> 0));
                } else if(matchScore[0] < matchScore[1]) {
                    scores.put(teamA, scores.computeIfAbsent(teamA, k -> 0));
                    scores.put(teamB, scores.computeIfAbsent(teamB, k -> 0) + 3);
                } else {
                    scores.put(teamA, scores.computeIfAbsent(teamA, k -> 0) + 1);
                    scores.put(teamB, scores.computeIfAbsent(teamB, k -> 0) + 1);
                }
                goals.put(teamA, goals.computeIfAbsent(teamA, k -> 0) + matchScore[0] - matchScore[1]);
                goals.put(teamB, goals.computeIfAbsent(teamB, k -> 0) + matchScore[1] - matchScore[0]);
            }
        }
        TreeMap<int[], String> map = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int first = Integer.compare(o2[0], o1[0]);
                if(first == 0) {
                    return Integer.compare(o2[1], o1[1]);
                } else {
                    return first;
                }
            }
        });
        for (String team : goals.keySet()) {
            map.put(new int[]{scores.get(team), goals.get(team)}, team);
        }
        Iterator<Map.Entry<int[], String>> it = map.entrySet().iterator();
        return new String[] {it.next().getValue(), it.next().getValue()};
    }
}
