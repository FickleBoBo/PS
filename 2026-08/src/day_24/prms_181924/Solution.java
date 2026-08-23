package day_24.prms_181924;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] q : queries) {
            int tmp = arr[q[0]];
            arr[q[0]] = arr[q[1]];
            arr[q[1]] = tmp;
        }

        return arr;
    }
}
