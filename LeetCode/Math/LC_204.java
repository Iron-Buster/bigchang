package LeetCode.Math;

public class LC_204 {

//    204. 计数质数
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        var vis = new boolean[n + 1];
        vis[0] = vis[1] = true;
        int ans = 0;
        // 埃氏筛
        for (int i = 2; i < n; i++) {
            // i是素数
            if (!vis[i]) {
                ans++;
                // 划掉i的倍数
                for (int j = i * 2; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
