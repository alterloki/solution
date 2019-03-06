package ru.alterloki.algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SCC {

    public static final int COUNT = 875714;
    //public static final int COUNT = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("common/_410e934e6553ac56409b2cb7096a44aa_SCC.txt"));
        //BufferedReader br = new BufferedReader(new FileReader("common/s1.txt"));
        Object[] graph = new Object[COUNT + 1];
        Object[] reverseGraph = new Object[COUNT + 1];
        String line = br.readLine();
        while(line != null) {
            String[] parts = line.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);

            List<Integer> tos;
            if(graph[from] == null) {
                tos = new ArrayList<Integer>();
                graph[from] = tos;
            } else {
                tos = (List<Integer>) graph[from];
            }
            tos.add(to);

            List<Integer> froms;
            if(reverseGraph[to] == null) {
                froms = new ArrayList<>();
                reverseGraph[to] = froms;
            } else {
                froms = (List<Integer>) reverseGraph[to];
            }
            froms.add(from);

            line = br.readLine();
        }

        int[] finishingTimes = new int[COUNT + 1];

        dfsLoop(reverseGraph, finishingTimes);
        int[] leaders = dfsLoopStraight(graph, finishingTimes);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < leaders.length; i++) {
            int leader = leaders[i];
            Integer count = map.get(leader);
            if(count == null) {
                count = 0;
            }
            map.put(leader, count + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey() > 1) {
                list.add(entry.getValue());
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        int count = 0;
        for (Integer sz : list) {
            System.out.println(sz);
            count++;
            if(count == 5) {
                break;
            }
        }
    }

    private static int[] dfsLoopStraight(Object[] graph, int[] finishingTimes) {
        int[] leaders = new int[graph.length];
        boolean[] explored = new boolean[graph.length];
        int[] s = new int[1];
        for(int i = finishingTimes.length - 1; i > 0; i--) {
            int vIndex = finishingTimes[i];
            if(!explored[vIndex]) {
                s[0] = vIndex;
                dfsStraight(graph, finishingTimes, explored, leaders, s, vIndex);
            }
        }
        return leaders;
    }

    private static void dfsStraight(Object[] graph, int[] finishingTimes, boolean[] explored, int[] leaders, int[] s,
                                    int vIndex) {
        explored[vIndex] = true;
        leaders[vIndex] = s[0];
        List<Integer> tos = (List<Integer>) graph[vIndex];
        if(tos != null) {
            for (Integer to : tos) {
                if(!explored[to]) {
                    dfsStraight(graph, finishingTimes, explored, leaders, s, to);
                }
            }
        }
    }

    private static void dfsLoop(Object[] reverseGraph, int[] finishingTimes) {
        int[] t = new int[1];
        boolean[] explored = new boolean[reverseGraph.length];
        t[0] = 0;
        for(int i = reverseGraph.length - 1; i > 0; i--) {
            if(!explored[i]) {
                dfs(reverseGraph, finishingTimes, explored, t, i);
            }
        }
    }

    private static void dfs(Object[] reverseGraph, int[] finishingTimes, boolean[] explored, int[] t, int i) {
        explored[i] = true;
        List<Integer> tos = (List<Integer>) reverseGraph[i];
        if(tos != null) {
            for (Integer to : tos) {
                if (!explored[to]) {
                    dfs(reverseGraph, finishingTimes, explored, t, to);
                }
            }
        }
        t[0]++;
        finishingTimes[t[0]] = i;
    }
}
