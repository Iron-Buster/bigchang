package BigChang;

import java.io.*;

public class P1069 {

    // TODO
//    携程算法岗-2023.3.7-第四题:游游买商品

    static int N = 1001;
    static long[][] a;
    static Long[][][] memo;

    // state记录上一件商品是否使用了半价 1-是 0-否
    static long dfs(int i, int state, int n, int m) {
        if (m < 0) return Integer.MIN_VALUE;
        if (i >= n) return 0;
        if (memo[i][m][state] != null) {
            return memo[i][m][state];
        }
        long x, z, y = 0;
        // 原价买第i件物品
        x = a[i][1] + dfs(i + 1, 0, n, (int) (m - a[i][0]));
        if (state == 0) {
            // 可选是否半价购买
            y = a[i][1] + dfs(i + 1, 1, n, (int) (m - (a[i][0] / 2)));
        }
        // 不买第i件商品
        z = dfs(i + 1, state, n, m);
        long ans = Math.max(Math.max(x, y), z);
        return memo[i][m][state] = ans;
    }

    static void solve(int n, int x) {
        long ans = dfs(0, 1, n, x);
        out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int x = nextInt();
        a = new long[n][2];
        memo = new Long[N][N][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nextLong();
        }
        for (int i = 0; i < n; i++) {
            a[i][1] = nextLong();
        }
        solve(n, x);
        out.close();
    }


    static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(ins);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String nextString() throws IOException {
        return ins.readLine();
    }
}
