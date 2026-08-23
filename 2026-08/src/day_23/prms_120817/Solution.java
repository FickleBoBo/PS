package day_23.prms_120817;

class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        return sum / numbers.length;
    }
}
