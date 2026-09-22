package day_22.prms_181833;

class Solution {
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }

        return arr;
    }
}
