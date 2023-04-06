package BigChang;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1112 {

//    字节春招后端-2023.03.24-第一题-捡芝麻丢西瓜
    static long[][] arr = new long[100001][2];
    static long[] memo = new long[100001];

    static long dfs(int i, int n) {
        if (i >= n) return 0;
        if (memo[i] != -1) return memo[i];
        // 不选
        long a = dfs(i + 1, n);
        // 选
        long b = arr[i][0] + dfs((int) (i + 1 + arr[i][1]), n);
        long ans = Math.max(a, b);
        return memo[i] = ans;
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextLong();
            arr[i][1] = in.nextLong();
        }
        Arrays.fill(memo, -1);
        long ans = dfs(0, n);
        out.print(ans);
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
