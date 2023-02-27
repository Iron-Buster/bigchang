package LeetCode.Competition.weekly.wr326;

import java.util.HashSet;

public class T2 {

//    数组乘积中的不同质因数数目
//    给你一个正整数数组 nums ，对 nums 所有元素求积之后，
//    找出并返回乘积中 不同质因数 的数目

//    注意：
//
//    质数 是指大于 1 且仅能被 1 及自身整除的数字。
//    如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。

//    示例 1：
//
//    输入：nums = [2,4,3,7,10,6]
//    输出：4
//    解释：
//    nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7 。
//    共有 4 个不同的质因数，所以返回 4 。

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            for (int i = 2; num > 1; i++) {
                for (; num % i == 0; num /= i) {
                    set.add(i);
                }
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 10, 6};
        System.out.println(new T2().distinctPrimeFactors(nums));
    }
}

