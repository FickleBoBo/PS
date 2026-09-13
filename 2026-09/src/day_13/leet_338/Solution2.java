package day_13.leet_338;

class Solution2 {
    public int[] countBits(int n) {
        int[] ans = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }
}
