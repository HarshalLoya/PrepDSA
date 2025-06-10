
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoring {

    private static boolean isSafe(int vertex, int color, int[] colors, List<List<Integer>> adjList) {
        for (int neighbor : adjList.get(vertex)) {
            if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int vertex, int m, int[] colors, List<List<Integer>> adjList) {
        if (vertex == adjList.size()) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(vertex, c, colors, adjList)) {
                colors[vertex] = c;
                if (solve(vertex + 1, m, colors, adjList)) {
                    return true;
                }
                colors[vertex] = 0;
            }
        }
        return false;
    }

    private static List<List<Integer>> buildAdjList(List<List<Integer>> edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.getFirst();    // edge.get(0)
            int v = edge.getLast();     // edge.get(1)
            adjList.get(u).add(v);
            adjList.get(v).add(u);  // undirected graph
        }
        return adjList;
    }

    public static boolean graphColoring(List<List<Integer>> edges, int n, int m) {
        List<List<Integer>> adjList = buildAdjList(edges, n);
        int[] colors = new int[n];
        return solve(0, m, colors, adjList);
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));

        System.out.println(edges);

        int n = 4;  // number of vertices 
        int m = 2;  // number of colors

        System.out.println(graphColoring(edges, n, m));
    }
}
