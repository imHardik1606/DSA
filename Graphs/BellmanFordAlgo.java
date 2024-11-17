import java.util.ArrayList;

public class BellmanFordAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0->vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1-vertex
        graph[1].add(new Edge(1, 2, -4));

        // 2-vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3-vertex
        graph[3].add(new Edge(3, 4, 4));

        // 4-vertex
        graph[4].add(new Edge(4, 1, -1));

    }

    public static void createGraph2(ArrayList<Edge> graph) {

        // 0->vertex
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        // 1-vertex
        graph.add(new Edge(1, 2, -4));
        // 2-vertex
        graph.add(new Edge(2, 3, 2));
        // 3-vertex
        graph.add(new Edge(3, 4, 4));
        // 4-vertex
        graph.add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];


        // initialisation
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // algo - O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxtion
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V ){
        
        int dist[] = new int[V];


        // initialisation
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // algo - O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for(int j = 0; j<graph.size(); j++) {
                    Edge e = graph.get(j);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxtion
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        //@SuppressWarnings("unchecked")
        //ArrayList<Edge>[] graph = new ArrayList[V];
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph2(graph2);
        //bellmanFord(graph, 0);
        bellmanFord2(graph2, 0, V);
    }
}
