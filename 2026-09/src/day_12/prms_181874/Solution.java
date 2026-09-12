package day_12.prms_181874;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                sb.append('A');
            } else if ('B' <= c && c <= 'Z') {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
