package day_20.prms_181855;

class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[1 + 30];
        for (String s : strArr) {
            cnt[s.length()]++;
        }

        int max = 0;
        for (int x : cnt) {
            max = Math.max(max, x);
        }

        return max;
    }
}
