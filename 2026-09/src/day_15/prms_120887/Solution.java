package day_15.prms_120887;

class Solution {
    public int solution(int i, int j, int k) {
        int ans = 0;
        for (int x = i; x <= j; x++) {
            ans += count(x, k);
        }

        return ans;
    }

    static int count(int x, int k) {
        int cnt = 0;
        while (x > 0) {
            if (x % 10 == k) cnt++;
            x /= 10;
        }

        return cnt;
    }
}
