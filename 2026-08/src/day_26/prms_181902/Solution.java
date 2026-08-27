package day_26.prms_181902;

class Solution {
    public int[] solution(String my_string) {
        int[] cnt = new int[52];
        for (char c : my_string.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cnt[c - 'A']++;
            } else {
                cnt[c - 'a' + 26]++;
            }
        }

        return cnt;
    }
}
