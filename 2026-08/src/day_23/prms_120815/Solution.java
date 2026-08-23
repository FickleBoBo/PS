package day_23.prms_120815;

class Solution {
    public int solution(int n) {
        return n / gcd(n, 6);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
