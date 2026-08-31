package day_22.prms_120812;

class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000];
        for (int x : array) {
            cnt[x]++;
        }

        int ans = -1;
        int max = 0;
        boolean uniq = false;

        for (int i = 0; i < 1000; i++) {
            if (cnt[i] > max) {
                ans = i;
                max = cnt[i];
                uniq = true;
            } else if (cnt[i] == max) {
                uniq = false;
            }
        }

        return uniq ? ans : -1;
    }
}
