package day_31.prms_181879;

class Solution {
    public int solution(int[] num_list) {
        if (num_list.length >= 11) {
            int sum = 0;
            for (int x : num_list) {
                sum += x;
            }
            return sum;
        } else {
            int mul = 1;
            for (int x : num_list) {
                mul *= x;
            }
            return mul;
        }
    }
}
