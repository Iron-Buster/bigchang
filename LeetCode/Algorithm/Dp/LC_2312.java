package LeetCode.Algorithm.Dp;

import java.util.HashMap;

public class LC_2312 {


//    2312. 卖木头块

    int[][] vals;
    // Long[][] memo = new Long[510][510];
    public long sellingWood(int m, int n, int[][] prices) {
        vals = new int[m + 1][n + 1]; // vals[i][j] 表示卖出高i宽j的价格
        for (var p : prices) {
            vals[p[0]][p[1]] = p[2];
        }
        var dp = new long[m + 1][n + 1];
        // dp[i][j] 表示切割高i 宽j 的木块能得到的最多钱数
        // dp[i][j] = prices[i][j] 直接卖
        // 枚举两种切法
        // for k in (1, i) max(dp[k][j] + dp[i-k][j])
        // for k in (1, j) max(dp[i][k] + dp[i][j-k])
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = vals[i][j];
                // ans = Math.max(ans, dfs(i, j));
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i-k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j-k]);
                }
            }
        }
        return dp[m][n];
    }
    // 你可以 水平切割，垂直切割 或者 将整块卖出
    // long dfs(int m, int n) {
    //     if (memo[m][n] != null) return memo[m][n];
    //     long ans = vals[m][n];
    //     for (int k = 1; k < m; k++) {   // 垂直切割
    //         ans = Math.max(ans, dfs(k, n) + dfs(m - k, n));
    //     }
    //     for (int k = 1; k < n; k++) {   // 水平切割
    //         ans = Math.max(ans, dfs(m, k) + dfs(m, n - k));
    //     }
    //     memo[m][n] = ans;
    //     return ans;
    // }


    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[][] prices = {{1, 4, 2}, {2, 2, 7}, {2, 1, 3}};
        System.out.println(new LC_2312().sellingWood(m, n, prices));
    }
}
