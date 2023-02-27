package LeetCode.Algorithm.Bfs;

import java.util.LinkedList;

public class LC_1091 {

//    1091. 二进制矩阵中的最短路径

    int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {1, 0}, {1, 1}, {0, 1}, {1, -1}, {0, -1}};
    boolean[][] vis = new boolean[110][110];
    int m, n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        var q = new LinkedList<Node>();
        if (grid[0][0] == 1) return -1;
        q.offer(new Node(0, 0, 1));
        while (!q.isEmpty()) {
            Node p = q.poll();
            int x = p.x, y = p.y;
            if (x == m-1 && y == n-1) return p.step;
            vis[x][y] = true;
            for (int i = 0; i < 8; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                if (grid[nx][ny] == 1) continue;
                vis[nx][ny] = true;
                q.offer(new Node(nx, ny, p.step + 1));
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int step;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
