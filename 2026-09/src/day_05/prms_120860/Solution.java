package day_05.prms_120860;

class Solution {
    public int solution(int[][] dots) {
        int minX = Math.min(Math.min(dots[0][0], dots[1][0]), Math.min(dots[2][0], dots[3][0]));
        int maxX = Math.max(Math.max(dots[0][0], dots[1][0]), Math.max(dots[2][0], dots[3][0]));
        int minY = Math.min(Math.min(dots[0][1], dots[1][1]), Math.min(dots[2][1], dots[3][1]));
        int maxY = Math.max(Math.max(dots[0][1], dots[1][1]), Math.max(dots[2][1], dots[3][1]));
        return (maxX - minX) * (maxY - minY);
    }
}
