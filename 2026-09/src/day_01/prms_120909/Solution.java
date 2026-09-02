package day_01.prms_120909;

class Solution {
    public int solution(int n) {
        long r = Math.round(Math.sqrt(n));
        return r * r == n ? 1 : 2;
    }
}
