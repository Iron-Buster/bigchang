package LeetCode.Template;

public class BIT {

    int n;
    int[] tree;
    int[] nums;

    public BIT(int[] nums, int n) {
        this.n = n;
        this.nums = nums;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    int lowbit(int x) {
        return x & -x;
    }
    // 查询前缀和
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }
    // 在树状数组 x 位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += u;
        }
    }

    void update(int i, int val) {
        // 将[i,n]修改为val
       add(i + 1, val - nums[i]);
       nums[i] = val;
    }

    int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}
