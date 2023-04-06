package BigChang;

import java.io.*;

public class P1090 {


//    美团校招-2023.3.18.10点-第四题-商店 TODO

    static int N = 101;
    static int X = 5001;
    static int Y = 51;
    static Integer[][][] memo = new Integer[N][X][Y];
    static int[][] arr = new int[51][2];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int money = nextInt();
        int cnt = nextInt();
        for (int i = 1; i <= n; i++) {
            int a = nextInt(), b = nextInt();
            arr[i] = new int[]{a, b};
        }
        solve(n, money, cnt);
        out.close();
    }

    static void solve(int n, int money, int cnt) {
        int dfs = dfs(n, 1, 0, money, cnt);
        int ans1 = 0;
        int ans2 = 0x3f3f3f;
        for (int i = 1; i <= n; i++) {
            for (int j = money; j >= 1; j--) {
                for (int k = cnt; k >= 1; k--) {
                    if (memo[i][j][k] != null && memo[i][j][k] == dfs) {
                        ans2 = Math.min(ans2, j);
                    }
                }
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }

    static int dfs(int n, int i, int cost, int tot, int cnt) {
        if (cost > tot) return 0x3f3f3f;
        if (i > n) return cost;
        if (memo[i][cost][cnt] != null) {
            return memo[i][cost][cnt];
        }
        int ans, a = 0;
        if (cnt > 0) {
            // 使用折扣购买
            a =  dfs(n, i + 1,cost + arr[i][1],  tot, cnt - 1);
        }
        // 不使用折扣购买
        int b = dfs(n, i + 1,cost + arr[i][0], tot, cnt);
        // 不购买
        int c = dfs(n, i + 1, cost, tot, cnt);
        ans = Math.min(a, Math.min(b, c));
        return memo[i][cost][cnt] = ans;
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
