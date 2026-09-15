package day_15.prms_120884;

class Solution {
    public int solution(int chicken) {
        int sum = 0;
        int x = chicken;
        while (x >= 10) {
            sum += x / 10;
            x = x / 10 + x % 10;
        }

        return sum;
    }
}
