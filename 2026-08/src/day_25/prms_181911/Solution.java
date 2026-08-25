package day_25.prms_181911;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_strings.length; i++) {
            sb.append(my_strings[i], parts[i][0], parts[i][1] + 1);
        }

        return sb.toString();
    }
}
