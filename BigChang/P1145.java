package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1145 {

//    2023.4.2-网易有道研发岗-第四题-机器采草莓最优决策

    static int[][] mat = new int[1010][1010];
    static int[][] f = new int[1010][1010];

    static void solve(int n, int m, int g) {
        int ans = 0x3f3f3f;
        f[0][0] = mat[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i-1][0] + mat[i][0];
        }
        for (int j = 1; j < m; j++) {
            f[0][j] = f[0][j-1] + mat[0][j];
        }
        if (f[0][0] >= g) { out.print(0); return; }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]) + mat[i][j];
                if (f[i][j] >= g) {
                    ans = Math.min(ans, i+j);
                }
            }
        }
        out.print(ans == 0x3f3f3f ? -1 : ans);
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int g = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        solve(n, m, g);
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
