package BigChang;

import java.io.*;

public class P1085 {

//    蚂蚁春招-2023.3.16-组装电脑

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

    static final int N = 50;
    static int[] num = new int[N];      // 第i类零件个数
    static long[][] p = new long[N][N]; // 价格
    static long[][] v = new long[N][N]; // 性能
    static long ans = -1L;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long x = nextLong();
        for (int i = 1; i <= n; i++) {
            int m = nextInt();
            num[i] = m;
            for (int j = 1; j <= m; j++) {
                p[i][j] = nextInt();
            }
            for (int j = 1; j <= m; j++) {
                v[i][j] = nextInt();
            }
        }
        dfs(n, x, 0);
        out.print(ans);
        out.close();
    }

    static void dfs(int n, long x, long maxv) {
        if (n == 0) {
            ans = Math.max(ans, maxv);
            return;
        }
        for (int i = 1; i <= num[n]; i++) {
            if (x >= p[n][i]) {
                dfs(n - 1, x - p[n][i], maxv + v[n][i]);
            }
        }
    }
}
