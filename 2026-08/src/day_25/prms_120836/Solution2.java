package day_25.prms_120836;

class Solution2 {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i != n / i) cnt++;
            }
        }

        return cnt;
    }
}
