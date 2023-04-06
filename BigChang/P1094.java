package BigChang;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1094 {

//    米哈游春招后端-2023.03.19-第一题-米哈游的RBG矩阵

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] a = new char[1010][1010];
    static char[][] b = new char[1010][1010];
    static boolean[][] vis = new boolean[1010][1010];
    static int cnt1 = 0;
    static int cnt2 = 0;

    static void dfs1(int x, int y, int n, int m) {
        if (vis[x][y]) return;
        vis[x][y] = true;
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || !check(x, y, nx, ny)) continue;
            dfs1(nx, ny, n, m);
        }
    }

    static boolean check(int x, int y, int nx, int ny) {
        if (b[x][y] == 'R') {
            return b[nx][ny] == 'R';
        } else if (b[x][y] == 'G') {
            return b[nx][ny] == 'G' || b[nx][ny] == 'B';
        } else  {
            return  b[nx][ny] == 'B' || b[nx][ny] == 'G';
        }
    }


    static void dfs2(int x, int y, int n, int m) {
        if (vis[x][y]) return;
        vis[x][y] = true;
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || a[nx][ny] != a[x][y]) continue;
            dfs2(nx, ny, n, m);
        }
    }


    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                b[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    ++cnt2;
                    dfs2(i, j, n, m);
                }
            }
        }
        for (boolean[] v : vis) Arrays.fill(v, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    ++cnt1;
                    dfs1(i, j, n, m);
                }
            }
        }
        out.print(cnt2 - cnt1);
        out.close();
    }


    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
