package day_31.prms_181883;

class Solution2 {
    public int[] solution(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            arr[i] += sum;
        }

        return arr;
    }
}
