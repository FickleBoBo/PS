package day_13.leet_268;

class Solution2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        return n * (n + 1) / 2 - sum;
    }
}
