package LeetCode.Skill.BitOperation;

public class BitOps {


    // 取反
    static int negate(int x) {
        return ~x + 1;
    }

    public static void main(String[] args) {
        System.out.println(negate(1));
    }
}
