package day_29.prms_120890;

class Solution {
    public int solution(int[] array, int n) {
        int ans = 0;
        int diff = 100;

        for (int x : array) {
            if (Math.abs(x - n) < diff) {
                ans = x;
                diff = Math.abs(x - n);
            } else if (Math.abs(x - n) == diff && x < ans) {
                ans = x;
            }
        }

        return ans;
    }
}
