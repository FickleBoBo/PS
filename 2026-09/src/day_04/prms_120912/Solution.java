package day_04.prms_120912;

class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        for (int x : array) {
            while (x > 0) {
                if (x % 10 == 7) cnt++;
                x /= 10;
            }
        }

        return cnt;
    }
}
