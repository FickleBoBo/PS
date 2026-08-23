package day_23.prms_181929;

class Solution {
    public int solution(int[] num_list) {
        long mul = 1, sum = 0;
        for (int x : num_list) {
            mul *= x;
            sum += x;
        }

        return mul < sum * sum ? 1 : 0;
    }
}
