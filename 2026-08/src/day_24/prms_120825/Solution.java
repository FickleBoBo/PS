package day_24.prms_120825;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            sb.repeat(c, n);
        }

        return sb.toString();
    }
}
