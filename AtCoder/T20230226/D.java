package AtCoder.T20230226;

import java.io.*;

public class D {

//    D - Flip Cards

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
    static int N;
    // dp[i][0]翻转第i张牌, dp[i][1]不翻转第i张牌
    static long[][] dp = new long[200010][2];
    static final int MOD = 998244353;
    public static void main(String[] args) throws IOException {
        N = nextInt();
        dp[1][0] = dp[1][1] = 1;
        long tmpA = nextLong();
        long tmpB = nextLong();
        for (int i = 2; i <= N; i++) {
            long nextA = nextLong();
            long nextB = nextLong();
            if (nextA != tmpA) dp[i][0] = (dp[i][0] + dp[i - 1][0]) % MOD;
            if (nextB != tmpB) dp[i][1] = (dp[i][1] + dp[i - 1][1]) % MOD;
            if (nextA != tmpB) dp[i][0] = (dp[i][0] + dp[i - 1][1]) % MOD;
            if (nextB != tmpA) dp[i][1] = (dp[i][1] + dp[i - 1][0]) % MOD;
            tmpA = nextA;
            tmpB = nextB;
        }
        out.print((dp[N][0] + dp[N][1]) % MOD);
        out.close();
    }
}