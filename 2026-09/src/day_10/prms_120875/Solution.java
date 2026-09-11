package day_10.prms_120875;

class Solution {
    public int solution(int[][] dots) {
        int[] p1 = dots[0], p2 = dots[1], p3 = dots[2], p4 = dots[3];
        return isParallel(p1, p2, p3, p4) || isParallel(p1, p3, p2, p4) || isParallel(p1, p4, p2, p3) ? 1 : 0;
    }

    static boolean isParallel(int[] p1, int[] p2, int[] p3, int[] p4) {
        return (p1[0] - p2[0]) * (p3[1] - p4[1]) == (p3[0] - p4[0]) * (p1[1] - p2[1]);
    }
}
