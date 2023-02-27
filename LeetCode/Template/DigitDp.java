package LeetCode.Template;


/*
    数位DP模板
 */
public class DigitDp {


    // DFS状态
    // 常见的三个状态
    // 1.枚举到第几位 (pos)
    // 2.判断前面是否紧贴上限 (limit)
    // 3.前面的数是否全为前导0 (zero)
    // 三个状态转移到下一位
    // 1.pos -> pos + 1
    // 2.limit -> limit && a[i] = 当前这时最高位
    // 3.zero -> zero && a[i] = 0

}
