package ru.alterloki;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testMerge() {
        /*5 8
        2 5
        2 3
        7 2
        2 7*/
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        graph.mergeEdge(10);
        graph.mergeEdge(5);
        graph.mergeEdge(3);
        graph.mergeEdge(10);
        System.out.println(graph.getVertexCount());
    }
}
