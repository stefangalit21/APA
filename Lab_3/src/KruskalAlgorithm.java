import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    private Graph graph;
    private int iterationCount;

    public KruskalAlgorithm(Graph graph) {
        this.graph = graph;
        this.iterationCount = 0;
    }

    public void kruskalMST() {
        Collections.sort(graph.edges);
        int[] parent = new int[graph.V];
        for (int i = 0; i < graph.V; i++)
            parent[i] = i;

        List<Edge> result = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : graph.edges) {
            iterationCount++;
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                result.add(edge);
                totalWeight += edge.weight;
                union(parent, x, y);
            }
        }

        System.out.println("Kruskal's MST Total Cost: " + totalWeight);
        System.out.println("Kruskal's Algorithm Iterations: " + iterationCount);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[xroot] = yroot;
    }
}
