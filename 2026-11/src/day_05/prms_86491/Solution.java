package day_05.prms_86491;

class Solution {
    public int solution(int[][] sizes) {
        for (int[] x : sizes) {
            if (x[0] < x[1]) {
                int tmp = x[0];
                x[0] = x[1];
                x[1] = tmp;
            }
        }

        int w = 0, h = 0;
        for (int[] x : sizes) {
            w = Math.max(w, x[0]);
            h = Math.max(h, x[1]);
        }

        return w * h;
    }
}
