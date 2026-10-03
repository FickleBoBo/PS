package day_13.leet_338;

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            int x = i;
            int cnt = 0;
            while (x > 0) {
                if ((x & 1) == 1) cnt++;
                x >>= 1;
            }
            ans[i] = cnt;
        }

        return ans;
    }
}
