package day_22.prms_120813;

class Solution {
    public int[] solution(int n) {
        int[] arr = new int[(n + 1) / 2];
        int idx = 0;

        for (int i = 1; i <= n; i += 2) {
            arr[idx++] = i;
        }

        return arr;
    }
}
