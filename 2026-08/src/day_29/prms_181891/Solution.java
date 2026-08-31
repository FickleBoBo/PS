package day_29.prms_181891;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] ans = new int[num_list.length];
        System.arraycopy(num_list, n, ans, 0, num_list.length - n);
        System.arraycopy(num_list, 0, ans, num_list.length - n, n);
        return ans;
    }
}
