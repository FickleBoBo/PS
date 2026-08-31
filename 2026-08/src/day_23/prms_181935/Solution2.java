package day_23.prms_181935;

class Solution2 {
    public int solution(int n) {
        if (n % 2 != 0) {
            int k = (n + 1) / 2;
            return k * k;
        } else {
            int k = n / 2;
            return 2 * k * (k + 1) * (2 * k + 1) / 3;
        }
    }
}
