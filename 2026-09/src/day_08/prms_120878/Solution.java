package day_08.prms_120878;

class Solution {
    public int solution(int a, int b) {
        int q = b / gcd(a, b);
        while (q % 2 == 0) {
            q /= 2;
        }
        while (q % 5 == 0) {
            q /= 5;
        }

        return q == 1 ? 1 : 2;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
