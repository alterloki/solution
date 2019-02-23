package ru.alterloki.algorithm;

import ru.alterloki.Graph;

import java.io.*;
import java.util.*;
import java.util.function.UnaryOperator;

public class Kager {

    public static final String TITLE = "A-large";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("common/small_kager.out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("common/_f370cd8b4d3482c940e4a57f489a200b_kargerMinCut.txt"));
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
        new Kager().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        Graph graph = new Graph();
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] parts = s.split("\t");
            if(parts.length > 0) {
                int vertexId = Integer.parseInt(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    int pairId = Integer.parseInt(parts[i]);
                    if (vertexId < pairId) {
                        graph.addEdge(vertexId, pairId);
                    }
                }
            }
        }
        int count = (int) ((double)graph.getVertexCount() * graph.getVertexCount() * Math.log(graph.getVertexCount()));
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < count; i++) {
            int current = solveOnce(graph);
            System.out.println(current);
            if(current < min) {

                min = current;
            }
        }
        System.out.println(min);
    }

    private int solveOnce(Graph graph) {
        Random random = new Random();
        Graph currentGraph = graph.copyGraph();
        while(currentGraph.getVertexCount() > 2) {
            int edgeId = random.nextInt(currentGraph.getEdgeCount());
            currentGraph.mergeEdge(edgeId);
        }
        return countEdges(currentGraph);
    }

    private int countEdges(Graph current) {
        return current.getEdgeCount();
    }

}
