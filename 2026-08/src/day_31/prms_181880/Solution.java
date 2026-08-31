package day_31.prms_181880;

class Solution {
    public int solution(int[] num_list) {
        int cnt = 0;
        for (int x : num_list) {
            while (x > 1) {
                x /= 2;
                cnt++;
            }
        }

        return cnt;
    }
}
