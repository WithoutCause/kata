package leetcode;

public class NthUglyNumber264 {

    public static int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1; //丑数第一个元素是 1
        int a = 0, b = 0, c = 0; // 三个指针，分别对应 2 3 5 这三个基础因子
        for (int i = 1; i < n; i++) { // 循环从 1 开始，因为 0 已经设置成 1 了
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            // 从上面选最小的数放进 res[i] 的位置
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) {
                a++;
            }
            if (res[i] == n3) {
                b++;
            }
            if (res[i] == n5) {
                c++;
            }
        }
        return res[n - 1];
    }

}
