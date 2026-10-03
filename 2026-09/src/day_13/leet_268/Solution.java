package day_13.leet_268;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[1 + n];
        for (int x : nums) {
            seen[x] = true;
        }

        for (int i = 0; i <= n; i++) {
            if (!seen[i]) return i;
        }

        return -1;
    }
}
