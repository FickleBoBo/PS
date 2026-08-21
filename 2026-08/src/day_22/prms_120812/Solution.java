package day_22.prms_120812;

class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000];
        for (int x : array) {
            cnt[x]++;
        }

        int ans = -1;
        int max = 0;
        boolean flag = false;
        for (int i = 0; i < 1000; i++) {
            if (cnt[i] > max) {
                ans = i;
                max = cnt[i];
                flag = true;
            } else if (cnt[i] == max) {
                flag = false;
            }
        }

        if (flag) return ans;
        return -1;
    }
}
