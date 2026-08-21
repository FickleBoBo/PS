package day_22.prms_181939;

class Solution {
    public int solution(int a, int b) {
        int x = Integer.parseInt("" + a + b);
        int y = Integer.parseInt("" + b + a);
        return Math.max(x, y);
    }
}
