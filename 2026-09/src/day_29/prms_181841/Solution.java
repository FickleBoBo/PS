package day_29.prms_181841;

class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        for (String s : str_list) {
            if (!s.contains(ex)) sb.append(s);
        }

        return sb.toString();
    }
}
