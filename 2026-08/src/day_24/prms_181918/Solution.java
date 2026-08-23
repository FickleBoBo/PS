package day_24.prms_181918;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int i = 0;
        int idx = 0;

        while (i < arr.length) {
            if (idx == 0 || stk[idx - 1] < arr[i]) {
                stk[idx++] = arr[i++];
            } else {
                idx--;
            }
        }

        int[] ans = new int[idx];
        System.arraycopy(stk, 0, ans, 0, idx);
        return ans;
    }
}
