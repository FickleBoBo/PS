package day_23.prms_120821;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = num_list[i];
            num_list[i] = num_list[n - 1 - i];
            num_list[n - 1 - i] = tmp;
        }

        return num_list;
    }
}
