package LeetCode.Algorithm.Dp;

public class LC_2320 {

    /*
        2320. 统计放置房子的方式数
     */
    private int mod = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        // dp[i][j] 表示第i块地皮 放置 或者 不防置的方案数
        var dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        // 考虑单独一侧
        for (int i = 2; i <= n; i++) {
            // 当前放置 -> 前面一块不防置
            dp[i][1] = dp[i - 1][0] % mod;
            // 不放置   -> 前面一块可放置可不防置
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) % mod;
        }
        long cnt = (dp[n][0] + dp[n][1]) % mod;
        // 上一侧每一个方案 与下面都可以组成 dp[n]种方案,所以两侧的方案数=cnt*cnt
        return (int) (cnt * cnt % mod);
    }

    public static void main(String[] args) {

    }
}
