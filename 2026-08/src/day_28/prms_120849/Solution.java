package day_28.prms_120849;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
            sb.append(c);
        }

        return sb.toString();
    }
}
