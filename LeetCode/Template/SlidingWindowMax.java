package LeetCode.Template;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMax {


    // 滑动窗口的最大值

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var res = new int[n - k + 1];
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast(); // 不停的删除比新元素小的队尾元素
            }
            q.offer(i);
            if (i >= k - 1) { // 窗口大小刚好为k
                while (!q.isEmpty() && q.peekFirst() < i - k + 1) { // 检查队首元素是否在窗口区间
                    q.pollFirst(); // 不合法的窗口下标
                }
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMax().maxSlidingWindow(nums, k)));
    }
}
