package LeetCode.Algorithm.Greedy;

public class LC_1053 {

//    1053. 交换一次的先前排列
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        // 1.从后往前找第一个逆序元素
        // 2.在这个逆序元素后面找一个比它小的最大值 进行交换
        int idx1 = -1, idx2 = -1;
        int rev = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                idx1 = i;
                rev = arr[i];
                break;
            }
        }
        // System.out.println("idx1 => " + idx1);
        if (idx1 == -1) return arr;
        int max = Integer.MIN_VALUE;
        for (int i = idx1 + 1; i < n; i++) {
            if (arr[i] > max && arr[i] < rev) {
                max = arr[i];
                idx2 = i;
            }
        }
        swap(arr, idx1, idx2);
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
