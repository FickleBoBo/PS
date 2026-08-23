package day_24.prms_181925;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            int prv = numLog[i - 1];
            int cur = numLog[i];

            if (prv + 1 == cur) {
                sb.append("w");
            } else if (prv - 1 == cur) {
                sb.append("s");
            } else if (prv + 10 == cur) {
                sb.append("d");
            } else {
                sb.append("a");
            }
        }

        return sb.toString();
    }
}
