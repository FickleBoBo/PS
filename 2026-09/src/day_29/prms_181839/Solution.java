package day_29.prms_181839;

class Solution {
    public int solution(int a, int b) {
        if (a % 2 != 0 && b % 2 != 0) return a * a + b * b;
        if (a % 2 != 0 || b % 2 != 0) return 2 * (a + b);
        return Math.abs(a - b);
    }
}
