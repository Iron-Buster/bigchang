package BigChang;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1167 {

//    2023.04.08-美团春招-第二题-必经之路

    static int N;
    static ArrayList<Integer>[] g;

    static void solve(int x, int y) {
        // 分别找以x为根 和以y为根的子树最长深度
        int ans = dfs(x, y) + dfs(y, x) + 1;
        out.println(ans);
    }

    static int dfs(int x, int fa) {
        int cnt = -1;
        for (int y : g[x]) {
            if (y != fa) {
                cnt = Math.max(cnt, dfs(y, x));
            }
        }
        return cnt + 1;
    }

    public static void main(String[] args) throws IOException {
        N = in.nextInt();
        g = new ArrayList[N+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 2; i <= N; i++) {
            int pi = in.nextInt();
            g[pi].add(i);
            g[i].add(pi);
        }
        int x = in.nextInt();
        int y = in.nextInt();
        solve(x, y);
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
