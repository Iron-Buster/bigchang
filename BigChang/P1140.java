package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1140 {

//    2023.04.01-第四题-倒水魔法

    static long[] a = new long[3001]; // 最大容量
    static long[] b = new long[3001]; // 初始容量
    static long[] cost = new long[3001];
    static long[] sum = new long[3002];
    static Long[] memo = new Long[3002];

    // 每个杯子装满 有两种状态 1.通过消耗法力值 2.前一个杯子溢出
    // 求一个min(A, B)

    static long dfs(int i, int n) {
        if (i > n) return 0;
        if (memo[i] != null) return memo[i];
        long ans = (a[i] - b[i]) * cost[i]; // 通过消耗法力值
        for (int j = 1; j < i; j++) {
            long v = cost[j] * (sum[i] - sum[j]); // 前一个杯子溢出
            ans = Math.min(ans, v + dfs(j, n));
        }
        memo[i] = ans;
        return ans;
    }


    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }
        long p = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextLong();
            sum[i] = a[i] - b[i];
            sum[i] += p;
            p = sum[i];
        }
        for (int i = 1; i <= n; i++) {
            cost[i] = in.nextLong();
        }
        int m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            dfs(i, n);
        }
        while (m-- > 0) {
            int q = in.nextInt();
            out.print(memo[q] + " ");
        }
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
