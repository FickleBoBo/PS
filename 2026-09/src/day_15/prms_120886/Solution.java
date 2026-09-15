package day_15.prms_120886;

class Solution {
    public int solution(String before, String after) {
        int[] cnt = new int[26];
        for (char c : before.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : after.toCharArray()) {
            cnt[c - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) return 0;
        }

        return 1;
    }
}
