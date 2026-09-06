package day_05.prms_120869;

class Solution {
    public int solution(String[] spell, String[] dic) {
        String word = String.join("", spell);
        for (String s : dic) {
            if (isAnagram(word, s)) return 1;
        }

        return 2;
    }

    static boolean isAnagram(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            cnt[c - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) return false;
        }

        return true;
    }
}
