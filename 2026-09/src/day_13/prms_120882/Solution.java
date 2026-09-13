package day_13.prms_120882;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int order = 1;
            for (int j = 0; j < n; j++) {
                if (score[i][0] + score[i][1] < score[j][0] + score[j][1]) order++;
            }
            ans[i] = order;
        }

        return ans;
    }
}
