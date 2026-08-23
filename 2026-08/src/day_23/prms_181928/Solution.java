package day_23.prms_181928;

class Solution {
    public int solution(int[] num_list) {
        int odd = 0, even = 0;

        for (int x : num_list) {
            if (x % 2 == 1) {
                odd = odd * 10 + x;
            } else {
                even = even * 10 + x;
            }
        }

        return odd + even;
    }
}
