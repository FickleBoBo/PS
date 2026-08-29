package day_29.prms_120891;

class Solution {
    public int solution(int order) {
        int cnt = 0;
        while (order > 0) {
            int r = order % 10;
            if (r == 3 || r == 6 || r == 9) cnt++;
            order /= 10;
        }

        return cnt;
    }
}
