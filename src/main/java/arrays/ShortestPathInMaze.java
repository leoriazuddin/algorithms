package arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given matrix and two points, find the shortest path from source to destination
 *  https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 * time: O(mn)
 *
 */
public class ShortestPathInMaze {
    public static void main(String[] args) {
        int m[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        System.out.println(sp(m, new Point(0,0), new Point(3, 4)));
    }

    static int sp(int[][] m, Point source, Point destination) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        if (source.x == destination.x && source.y == destination.y)
            return result;

        q.add(new Node(source, 0));
        int rLen = m.length, cLen = m[0].length;

        boolean[][] visited = new boolean[m.length][m[0].length];
        int rows[] = {-1, 0, 0, 1};
        int cols[] = {0, -1, 1, 0};

        while (!q.isEmpty()) {
            Node n = q.poll();
            Point p = n.p;

            visited[p.x][p.y] = true;
            if (p.x == destination.x && p.y == destination.y)
                return n.dist;

            for (int i = 0; i < 4; i++) {
                int row = p.x + rows[i];
                int col = p.y + cols[i];

                if (row >= 0 && row < rLen && col >= 0 && col < cLen && m[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new Node(new Point(row, col), n.dist + 1));
                }
            }
        }

        return result;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        Point p;
        int dist;

        public Node(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }
    }
}
