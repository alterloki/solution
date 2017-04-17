package week31;

import java.util.*;

/**
 * 0 1 1 1
 0 1 49 50
 1 2 1 2
 25/26
 * @author ashevenkov 13.04.17 14:11.
 */
public class SpanningTree {

    class Edge {

        private final int v;
        private final int w;
        private final int a;
        private final int b;

        public Edge(int v, int w, int a, int b) {
            this.v = v;
            this.w = w;
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int other(int v) {
            if (this.v == v) {
                return w;
            } else {
                return this.v;
            }
        }

    }

    public class DoubleWightedGraph {

        private Map<Integer, List<Edge>> edges = new HashMap<>();

        public void addEdge(Edge edge) {
            addEdgeToMap(edge.v, edge);
            addEdgeToMap(edge.w, edge);
        }

        private void addEdgeToMap(int a, Edge edge) {
            List<Edge> list = this.edges.get(a);
            if (list == null) {
                list = new ArrayList<>();
                this.edges.put(a, list);
            }
            list.add(edge);
        }

        public int v() {
            return edges.entrySet().iterator().next().getKey();
        }

        public int vCount() {
            return edges.size();
        }
    }

    public static void main(String[] args) {
        new SpanningTree().solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DoubleWightedGraph graph = new DoubleWightedGraph();
        for(int a0 = 0; a0 < m; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(u != v) {
                graph.addEdge(new Edge(u, v, a, b));
            }
        }
        int count = 0;
        boolean[] inside = new boolean[10001];
        int v = graph.v();
        inside[v] = true;
        int a = 0;
        int b = 0;
        Set<Edge> set = new HashSet<>();
        set.addAll(graph.edges.get(v));
        while(count < graph.vCount() - 1) {
            float max = 0;
            Edge edgeM = null;
            Iterator<Edge> it = set.iterator();
            while (it.hasNext()) {
                Edge edge = it.next();
                if(inside[edge.v] && inside[edge.w]) {
                    it.remove();
                } else {
                    float t = (float) (a + edge.a) / (b + edge.b);
                    if (t > max) {
                        max = t;
                        edgeM = edge;
                    }
                }
            }
            a += edgeM.a;
            b += edgeM.b;
            int newV = inside[edgeM.v] ? edgeM.w : edgeM.v;
            set.addAll(graph.edges.get(newV));
            inside[newV] = true;
            count++;
        }
        System.out.println(asFraction(a, b));
    }

    public long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    public String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

}

