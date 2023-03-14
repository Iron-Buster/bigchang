package BigChang;

import java.io.*;


public class P1074 {

    // 2023 3/12 滴滴笔试题 P2

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
        in.nextToken();
        return in.sval;
    }

    static Boolean[][][] memo = new Boolean[13][13][145];
    static int N;
    static int M;
    static int P;
    static String ans = "";


    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        P = nextInt();
        if (P > N * N) { out.print(-1); out.close(); return; }
        var dfs = dfs(1, N, P, new StringBuilder());
        if (!dfs) { out.print(-1); out.close(); return; }
        for (char c : ans.toCharArray()) {
            out.print(c + " ");
        }
        out.close();
    }

    static boolean dfs(int i, int n, int p, StringBuilder path) {
        if (i > M) {
            if (n != 0 || p != 0) return false; // 非法方案
            if (ans.equals("")) {
                ans = path.toString();
            } else {
                ans = ans.compareTo(path.toString()) > 0 ? path.toString() : ans;
            }
            return true;
        }
        if (n <= 0 || p < 0) return false;
        if (memo[i][n][p] != null) return memo[i][n][p];
        var ans = false;
        // 第i个包至少放一个
        path.append(1);
        ans = dfs(i + 1, n - 1, p - 1, path);
        path.deleteCharAt(path.length() - 1);
        // 第i个包放x个
        for (int x = 2; x <= n; x++) {
            path.append(x);
            ans |= dfs(i + 1, n - x, p - x * x, path);
            path.deleteCharAt(path.length() - 1); // 恢复现场
        }
        memo[i][n][p] = ans;                            // 记忆化
        return ans;
    }
}
