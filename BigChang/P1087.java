package BigChang;

import java.io.*;

public class P1087 {

//    美团校招-2023.3.18.10点-第一题-小美抓敌人

    static void solve(int n, int A, int B) throws IOException {
        var g = new int[1050][1050];
        while (n-- > 0) {
            int x = nextInt();
            int y = nextInt();
            g[x][y]++;
        }
        // 二维前缀和
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                g[i][j] += g[i - 1][j] + g[i][j - 1] - g[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = A + 1; i <= 1000; i++) {
            for (int j = B + 1; j <= 1000; j++) {
                int cnt = g[i][j] - g[i-A-1][j] - g[i][j-B-1] + g[i-A-1][j-B-1];
                ans = Math.max(ans, cnt);
            }
        }
        out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int A = nextInt();
        int B = nextInt();
        solve(n, A, B);
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
