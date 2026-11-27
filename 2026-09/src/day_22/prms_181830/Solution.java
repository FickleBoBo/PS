package day_22.prms_181830;

class Solution {
    public int[][] solution(int[][] arr) {
        int n = Math.max(arr.length, arr[0].length);
        int[][] ans = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, ans[i], 0, arr[i].length);
        }

        return ans;
    }
}
