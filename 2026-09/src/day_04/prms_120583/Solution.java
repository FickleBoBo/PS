package day_04.prms_120583;

class Solution {
    public int solution(int[] array, int n) {
        int cnt = 0;
        for (int x : array) {
            if (x == n) cnt++;
        }

        return cnt;
    }
}
