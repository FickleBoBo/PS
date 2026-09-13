package day_13.leet_191;

class Solution3 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            n &= (n - 1);
            cnt++;
        }

        return cnt;
    }
}
