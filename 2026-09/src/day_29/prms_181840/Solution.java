package day_29.prms_181840;

class Solution {
    public int solution(int[] num_list, int n) {
        for (int x : num_list) {
            if (x == n) return 1;
        }

        return 0;
    }
}
