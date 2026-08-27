package day_26.prms_120848;

class Solution {
    public int solution(int n) {
        int[] fact = new int[1 + 10];
        fact[0] = 1;

        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 10; i >= 1; i--) {
            if (fact[i] <= n) return i;
        }

        return -1;
    }
}
