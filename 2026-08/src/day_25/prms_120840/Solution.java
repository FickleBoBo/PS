package day_25.prms_120840;

class Solution {
    public int solution(int balls, int share) {
        long ans = 1;
        for (int i = 1; i <= share; i++) {
            ans = ans * (balls - i + 1) / i;
        }

        return (int) ans;
    }
}
