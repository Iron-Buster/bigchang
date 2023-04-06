package BigChang;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1142 {

//    2023.4.2-网易有道研发岗-第一题-最长k阶完美子序列

    static char[] cs;
    static int k;
    static int[][] f = new int[100001][130];

    static void solve() {
        for (int[] ff : f) {
            Arrays.fill(ff, -1);
        }
        dfs(0, 0);
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            int v = Arrays.stream(f[i]).max().getAsInt();
            ans = Math.max(ans, v);
        }
        out.print(ans);
    }

    static int dfs(int i, int p) {
        if (i >= cs.length) return 0;
        if (f[i][p] != -1) return f[i][p];
        int ans = 0;
        ans = Math.max(ans, dfs(i+1, p));
        if (p == 0 || Math.abs(cs[i] - p) <= k) {
            ans = Math.max(ans, 1 + dfs(i+1, cs[i]));
        }
        return f[i][p] = ans;
    }

    public static void main(String[] args) throws IOException {
        String s = in.next();
        k = in.nextInt();
        cs = s.toCharArray();
        solve();
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
