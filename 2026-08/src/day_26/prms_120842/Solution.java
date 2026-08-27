package day_26.prms_120842;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] arr = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length / n; i++) {
            System.arraycopy(num_list, i * n, arr[i], 0, n);
        }

        return arr;
    }
}
