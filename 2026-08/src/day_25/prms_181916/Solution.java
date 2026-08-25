package day_25.prms_181916;

class Solution {
    public int solution(int a, int b, int c, int d) {
        if (a == b && b == c && c == d) {
            return 1111 * a;
        } else if (b == c && c == d) {
            return (10 * b + a) * (10 * b + a);
        } else if (c == d && d == a) {
            return (10 * c + b) * (10 * c + b);
        } else if (d == a && a == b) {
            return (10 * d + c) * (10 * d + c);
        } else if (a == b && b == c) {
            return (10 * a + d) * (10 * a + d);
        } else if (a == b && c == d) {
            return (a + c) * Math.abs(a - c);
        } else if (a == c && b == d) {
            return (a + b) * Math.abs(a - b);
        } else if (a == d && b == c) {
            return (a + b) * Math.abs(a - b);
        } else if (a == b) {
            return c * d;
        } else if (a == c) {
            return b * d;
        } else if (a == d) {
            return b * c;
        } else if (b == c) {
            return a * d;
        } else if (b == d) {
            return a * c;
        } else if (c == d) {
            return a * b;
        } else {
            return Math.min(Math.min(a, b), Math.min(c, d));
        }
    }
}
