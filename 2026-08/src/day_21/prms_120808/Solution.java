package day_21.prms_120808;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int p = numer1 * denom2 + numer2 * denom1;
        int q = denom1 * denom2;
        int g = gcd(p, q);
        return new int[]{p / g, q / g};
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
