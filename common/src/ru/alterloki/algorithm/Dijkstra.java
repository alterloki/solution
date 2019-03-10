package ru.alterloki.algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dijkstra {

    public static int COUNT = 200 + 1;

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Vertex implements IndexedComparable<Vertex> {
        int minPathWeight;
        int id;

        public Vertex(int minPathWeight, int id) {
            this.minPathWeight = minPathWeight;
            this.id = id;
        }

        @Override
        public int getIndex() {
            return id;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(minPathWeight, o.minPathWeight);
        }
    }

    interface IndexedComparable<T> extends Comparable<T> {
        int getIndex();
    }

    static class Heap<P extends IndexedComparable> {
        private Map<Integer, Integer> vertex2heap = new HashMap<>();
        private List<P> heap;
        int lastIndex = -1;

        public Heap() {
            this.heap = new ArrayList<>();
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        public void insert(P value) {
            if(lastIndex == heap.size() - 1) {
                heap.add(value);
                lastIndex++;
            } else {
                heap.add(++lastIndex, value);
            }
            vertex2heap.put(value.getIndex(), lastIndex);
            int current = lastIndex;
            while(current > 0 && heap.get(current).compareTo(heap.get(parent(current))) < 0) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public P getMin() {
            return heap.get(0);
        }

        public P removeMin() {
            P min = getMin();
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            vertex2heap.remove(min.getIndex());
            lastIndex--;
            minHeapify(0);
            return min;
        }

        private void minHeapify(int i) {
            int leftIndex = leftChild(i);
            int rightIndex = rightChild(i);
            int smallest = i;
            if(leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(i)) < 0) {
                smallest = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightIndex;
            }
            if(smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }

        private void swap(int a, int b) {
            P temp = heap.get(a);
            heap.set(a, heap.get(b));
            vertex2heap.put(heap.get(a).getIndex(), a);
            heap.set(b, temp);
            vertex2heap.put(heap.get(b).getIndex(), b);
        }

        private P decreaseKey(int i, P newVal) {
            P result = heap.get(i);
            heap.set(i, newVal);
            while(i != 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {
                swap(i, parent(i));
                i = parent(i);
            }
            return result;
        }

        public P deleteKey(int i, P minValue) {
            P result = decreaseKey(i, minValue);
            removeMin();
            return result;
        }

        public Integer getPlaceByVertexIndex(int vertexIndex) {
            return vertex2heap.get(vertexIndex);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("common/_dcf1d02570e57d23ab526b1e33ba6f12_dijkstraData.txt"));
        List[] graph = new List[COUNT];
        String line = br.readLine();
        while(line != null) {
            String[] parts = line.split("\t");
            int nodeId = Integer.parseInt(parts[0]);
            List<Edge> list = new ArrayList<Edge>();
            for(int i = 1; i < parts.length; i++) {
                String[] edgeParts = parts[i].split(",");
                int toId = Integer.parseInt(edgeParts[0]);
                int weight  = Integer.parseInt(edgeParts[1]);
                list.add(new Edge(toId, weight));
            }
            graph[nodeId] = list;
            line = br.readLine();
        }
        int[] result = new Dijkstra().solve(graph);
        System.out.println(result[7] + "," + result[37] + "," + result[59] + "," + result[82] + "," +
                result[99] + "," + result[115] + "," + result[133] + "," + result[165] + "," +
                result[188] + "," + result[197]);
    }

    private Vertex removeFromHeap(Heap<Vertex> heap, int vertexId) {
        Integer placeByVertexIndex = heap.getPlaceByVertexIndex(vertexId);
        if(placeByVertexIndex != null) {
            return heap.deleteKey(placeByVertexIndex, new Vertex(Integer.MIN_VALUE, 0));
        } else {
            return null;
        }
    }

    private int[] solve(List[] graph) {
        Set<Integer> xs = new HashSet<>();
        int[] mins = new int[COUNT];
        mins[1] = 0;
        xs.add(1);
        Heap<Vertex> heap = new Heap<>();
        List<Edge> edges = (List<Edge>) graph[1];
        for (Edge edge : edges) {
            heap.insert(new Vertex(edge.weight, edge.to));
        }
        while(xs.size() < graph.length - 1) {
            Vertex minVertex = heap.removeMin();
            List<Edge> currentEdges = (List<Edge>) graph[minVertex.id];
            for (Edge currentEdge : currentEdges) {
                Vertex vertex = removeFromHeap(heap, currentEdge.to);
                if(!xs.contains(currentEdge.to)) {
                    int newLen = minVertex.minPathWeight + currentEdge.weight;
                    if(vertex != null) {
                        if (newLen < vertex.minPathWeight) {
                            vertex.minPathWeight = newLen;
                        }
                    } else {
                        vertex = new Vertex(newLen, currentEdge.to);
                    }
                    heap.insert(vertex);
                }
            }
            xs.add(minVertex.id);
            mins[minVertex.id] = minVertex.minPathWeight;
        }
        return mins;
    }
}
