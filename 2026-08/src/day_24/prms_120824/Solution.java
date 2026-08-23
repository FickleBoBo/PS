package day_24.prms_120824;

class Solution {
    public int[] solution(int[] num_list) {
        int odd = 0, even = 0;
        for (int x : num_list) {
            if (x % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }

        return new int[]{even, odd};
    }
}
