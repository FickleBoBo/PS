package day_13.leet_268;

class Solution3 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            ans ^= i;
        }
        for (int x : nums) {
            ans ^= x;
        }

        return ans;
    }
}
