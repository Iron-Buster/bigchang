package LeetCode.Competition.weekly.wr335;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T3 {

    public int findValidSplit(int[] nums) {
        // 互质: 左半部分 和 右半部分 没有公共质因子
        var left = new HashMap<Integer, Integer>();
        var right = new HashMap<Integer, Integer>();
        for (int num : nums) {
            for (int factor : divide(num)) {
                right.put(factor, right.getOrDefault(factor, 0) + 1);
            }
        }
        // 从左到右枚举最小分割点
        for (int i = 0; i < nums.length - 1; i++) {
            for (int factor : divide(nums[i])) {
                right.put(factor, right.getOrDefault(factor, 0) - 1);
                left.put(factor, left.getOrDefault(factor, 0) + 1);
                // 右边不存在factor这个因子, 那么左边保存factor也没有意义
                if (right.get(factor) <= 0) left.remove(factor);
                // find nice position
                if (left.isEmpty()) return i;
            }
        }
        return -1;
    }

    // 质因数分解
    List<Integer> divide(int x) {
        var list = new ArrayList<Integer>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                list.add(i);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) list.add(x);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 8, 15, 3, 5};
        System.out.println(new T3().findValidSplit(nums));
    }
}
