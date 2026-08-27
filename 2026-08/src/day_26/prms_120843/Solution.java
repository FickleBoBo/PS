package day_26.prms_120843;

class Solution {
    public int solution(int[] numbers, int k) {
        return numbers[2 * (k - 1) % numbers.length];
    }
}
