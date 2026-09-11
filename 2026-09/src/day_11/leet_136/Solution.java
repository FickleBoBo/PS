package day_11.leet_136;

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }

        return ans;
    }
}
