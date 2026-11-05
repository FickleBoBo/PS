package day_05.leet_53;

class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            cur = Math.max(x, cur + x);
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
