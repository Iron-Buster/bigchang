package LeetCode.Template;

public class TreeArray {

    int[] tree;
    int n;

    int lowbit(int x) {
        return x & -x;
    }
    // 查询前缀和
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }
    // 在树状数组 x位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }
}
