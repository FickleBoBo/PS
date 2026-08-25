package day_25.prms_120839;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (char c : rsp.toCharArray()) {
            if (c == '0') {
                sb.append("5");
            } else if (c == '2') {
                sb.append("0");
            } else {
                sb.append("2");
            }
        }

        return sb.toString();
    }
}
