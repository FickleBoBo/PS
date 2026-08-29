package day_29.prms_120893;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}
