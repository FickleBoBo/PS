package day_31.prms_181884;

class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for (int x : numbers) {
            sum += x;
            if (sum > n) return sum;
        }

        return -1;
    }
}
