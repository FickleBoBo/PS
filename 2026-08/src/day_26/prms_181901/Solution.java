package day_26.prms_181901;

class Solution {
    public int[] solution(int n, int k) {
        int[] arr = new int[n / k];
        int idx = 0;

        for (int i = k; i <= n; i += k) {
            arr[idx++] = i;
        }

        return arr;
    }
}
