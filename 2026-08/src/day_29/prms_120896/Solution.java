package day_29.prms_120896;

class Solution {
    public String solution(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1) sb.append((char) (i + 'a'));
        }

        return sb.toString();
    }
}
