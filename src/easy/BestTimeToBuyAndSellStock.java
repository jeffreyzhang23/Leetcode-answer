package easy;

import java.util.*;

/**
 * Created by Jeffrey on 2016/10/24.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int max = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}
