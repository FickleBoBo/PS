package day_22.prms_181942;

class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < str1.length()) {
            sb.append(str1.charAt(idx)).append(str2.charAt(idx));
            idx++;
        }

        return sb.toString();
    }
}
