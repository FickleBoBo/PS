package day_24.prms_120824;

class Solution {
    public int[] solution(int[] num_list) {
        int odd = 0;
        for (int x : num_list) {
            if (x % 2 != 0) odd++;
        }

        return new int[]{num_list.length - odd, odd};
    }
}
