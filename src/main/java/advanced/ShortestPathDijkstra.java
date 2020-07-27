package advanced;

import java.util.*;

/**
 * https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm/
 * Given set of vertices in a weighted graph. All weights are positive. Find shortest path from source to all vertices.
 *
 * Algorithm:
 *  Track shortestPath to all vertices in dist, track visited in visited.
 *  initialize dist to infinity, and keep updating with min distance as follows.
 *  if current node is not visited and if d(current node to its neighbor) < dist[neighbor], then dist[neighbor] = new distance
 *
 */
public class ShortestPathDijkstra {
    static class Edge {
        int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Graph {
        Map<Integer, List<Edge>> adjList = null;

        Graph(List<Edge> edges, int n) {
            adjList = new HashMap<>();

            for (Edge edge : edges) {
                adjList.computeIfAbsent(edge.source, k -> new ArrayList<>()).add(edge);
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 10),
                new Edge(0, 4, 3),
                new Edge(1, 2, 2),
                new Edge(1, 4, 4),
                new Edge(2, 3, 9),
                new Edge(3, 2, 7),
                new Edge(4, 1, 1),
                new Edge(4, 2, 8),
                new Edge(4, 3, 2));

        int n = 5;
        Graph g = new Graph(edges, n);
        int source = 0;
        shortestPath(g, source, n);
    }

    static void shortestPath(Graph g, int source, int n) {
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        q.add(new Node(source, 0));

        // initially, set distance from source to all vertices as infinity
        List<Integer> dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        boolean[] visited = new boolean[n];

        // distance from source to itself
        dist.set(source, 0);
        visited[source] = true;

        // track predecessor of a vertex
        int[] prev = new int[n];
        prev[source] = -1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int from = node.vertex;
            for (Edge e : g.adjList.get(from)) {
                int to = e.dest;
                int weight = e.weight;

                //relaxation
                if (!visited[to] && (dist.get(from) + weight) < dist.get(to)) {
                    dist.set(to, dist.get(from) + weight);
                    prev[to] = from;
                    q.add(new Node(to, dist.get(to)));
                }
            }

            visited[from] = true;
        }

        for (int i = 0; i < n; i++) {
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                List<Integer> route = new ArrayList<>();
                getRoute(prev, i, route);
                System.out.printf("Path (%d -> %d): Minimum Cost = %d and Route is %s", source, i, dist.get(i), route);
                System.out.println();
            }
        }
    }

    static void getRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
}
