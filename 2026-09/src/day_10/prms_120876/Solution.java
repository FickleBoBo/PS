package day_10.prms_120876;

class Solution {
    public int solution(int[][] lines) {
        int[] cnt = new int[100 + 1 + 100];
        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                cnt[i + 100]++;
            }
        }

        int ans = 0;
        for (int x : cnt) {
            if (x >= 2) ans++;
        }

        return ans;
    }
}
