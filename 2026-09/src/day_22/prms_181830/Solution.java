package day_22.prms_181830;

class Solution {
    public int[][] solution(int[][] arr) {
        int len = Math.max(arr.length, arr[0].length);
        int[][] res = new int[len][len];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, res[i], 0, arr[i].length);
        }

        return res;
    }
}
