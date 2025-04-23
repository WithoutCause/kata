package leetcode;

import java.util.Arrays;

public class FinalPrices1475 {

    public static int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    price = price - prices[j];
                    break;
                }
            }
            result[i] = price;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        int[] result = finalPrices(prices);
        System.out.println(Arrays.toString(result)); //输出：4,2,4,2,3
    }

}
