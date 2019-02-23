package ru.alterloki;

import java.util.*;

public class Graph {

    private Map<Integer, Map<Integer, List<int[]>>> vertex2Edges = new HashMap<>();
    private List<int[]> edges = new ArrayList<>();

    public void addEdge(int v1, int v2) {
        int[] edgeObj = {v1, v2};
        edges.add(edgeObj);
        addEdgeObject(v1, v2, edgeObj);
        addEdgeObject(v2, v1, edgeObj);
    }

    private void addEdgeObject(int from, int to, int[] edgeObj) {
        Map<Integer, List<int[]>> vertexEdgesMap = vertex2Edges.computeIfAbsent(from, k -> new HashMap<>());
        List<int[]> edgesList = vertexEdgesMap.computeIfAbsent(to, k -> new ArrayList<>());
        edgesList.add(edgeObj);
    }

    public int getVertexCount() {
        return vertex2Edges.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public void mergeEdge(int edgeIndex) {
        int[] edge = edges.get(edgeIndex);
        mergeEdge(edge[0], edge[1], edgeIndex);
    }

    public void mergeEdge(int from, int to, int edgeIndex) {
        removeEdge(from, to, edgeIndex);
        replaceAllInEdges(to, from);
        removeNode(to);
    }

    private void removeNode(int to) {
        Map<Integer, List<int[]>> edgesMap = vertex2Edges.get(to);
        edgesMap.clear();
        vertex2Edges.remove(to);
    }

    private void replaceAllInEdges(int to, int from) {
        for (Map.Entry<Integer, List<int[]>> entry : vertex2Edges.get(to).entrySet()) {
            Integer pairId = entry.getKey();
            Map<Integer, List<int[]>> edgesFromPair = vertex2Edges.get(pairId);
            List<int[]> currentEdgesList = edgesFromPair.get(to);
            for (int[] edge : currentEdgesList) {
                if(edge[0] == to) {
                    edge[0] = from;
                } else if(edge[1] == to) {
                    edge[1] = from;
                }
            }
            List<int[]> pairEdges = edgesFromPair.get(from);
            if(pairEdges == null) {
                edgesFromPair.put(from, currentEdgesList);
            } else {
                pairEdges.addAll(currentEdgesList);
            }
            edgesFromPair.remove(to);
            if(pairId != from) {
                List<int[]> oldEdges = vertex2Edges.get(from).get(pairId);
                if (oldEdges == null) {
                    vertex2Edges.get(from).put(pairId, entry.getValue());
                } else {
                    vertex2Edges.get(from).get(pairId).addAll(entry.getValue());
                    entry.getValue().clear();
                }
            }
        }
        vertex2Edges.get(to).clear();
        while(edgeExists(from, from)) {
            removeEdge(from, from);
        }
    }

    public boolean edgeExists(int from, int to) {
        Map<Integer, List<int[]>> vertexMap = vertex2Edges.get(from);
        if(vertexMap != null) {
            return vertexMap.containsKey(to);
        }
        return false;
    }

    public int[] removeEdge(int from, int to) {
        return removeEdge(from, to, -1);
    }

    public int[] removeEdge(int from, int to, int edgeIndex) {
        int[] removed = null;
        if(edgeIndex >= 0) {
            removed = edges.remove(edgeIndex);
        } else {
            Iterator<int[]> edgeIt = edges.iterator();
            while (edgeIt.hasNext()) {
                int[] next =  edgeIt.next();
                if((next[0] == from && next[1] == to) || next[1] == from && next[0] == to) {
                    removed = next;
                    edgeIt.remove();
                    break;
                }
            }
        }
        if(from != to) {
            removeWithList(to, from, removed);
        }
        return removeWithList(from, to, removed);
    }

    private int[] removeWithList(int from, int to, int[] removed) {
        Map<Integer, List<int[]>> integerListMap = vertex2Edges.get(from);
        List<int[]> edgeList = integerListMap.get(to);
        edgeList.remove(removed);
        if(edgeList.isEmpty()) {
            vertex2Edges.get(from).remove(to);
        }
        return removed;
    }

    public Graph copyGraph() {
        Graph graph = new Graph();
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }
        return graph;
    }
}
