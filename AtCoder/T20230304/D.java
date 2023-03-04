package AtCoder.T20230304;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class D {

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
    static int N, M = 0;
    static int[] vis;
    static int[] cnt;
    static int[] ecnt;
    // TODO
    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();

        vis = new int[N + 1];
        cnt = new int[N + 1];
        ecnt = new int[N + 1];
        List<Integer>[] adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int u = nextInt(), v = nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        var ok = true;
        for (int i = 1; i <= N; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, adj)) {
                    ok = false;
                    break;
                }
            }
        }
        out.print(ok ? "Yes" : "No");
        out.close();
    }

    static boolean dfs(int u, List<Integer>[] adj) {
        vis[u] = 1;
        cnt[u] = 1;
        ecnt[u] = adj[u].size(); // 边数
        for (int v : adj[u]) {
            if (vis[v] == 0) {
                if (!dfs(v, adj)) {
                    return false;
                }
                cnt[u] += cnt[v];
                ecnt[u] += ecnt[v];
            } else if (vis[v] == 1) {

            } else {
                return false;
            }
        }
        vis[u] = 2;
        if (cnt[u] != ecnt[u]) return false;
        return true;
    }
}
