package day_26.prms_181900;

class Solution {
    public String solution(String my_string, int[] indices) {
        char[] arr = my_string.toCharArray();
        for (int i : indices) {
            arr[i] = '\u0000';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '\u0000') sb.append(c);
        }

        return sb.toString();
    }
}
