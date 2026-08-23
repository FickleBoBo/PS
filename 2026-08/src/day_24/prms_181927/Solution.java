package day_24.prms_181927;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] ans = new int[n + 1];
        System.arraycopy(num_list, 0, ans, 0, n);

        if (num_list[n - 1] > num_list[n - 2]) {
            ans[n] = num_list[n - 1] - num_list[n - 2];
        } else {
            ans[n] = num_list[n - 1] * 2;
        }

        return ans;
    }
}
