package day_15.leet_121;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            diff = Math.max(diff, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return diff;
    }
}
