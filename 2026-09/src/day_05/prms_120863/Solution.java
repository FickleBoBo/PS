package day_05.prms_120863;

import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial);
        int[] cnt = {0, 0};

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+")) continue;

            if (token.endsWith("x")) {
                if (token.length() == 1) {
                    cnt[0]++;
                } else {
                    cnt[0] += Integer.parseInt(token.substring(0, token.length() - 1));
                }
            } else {
                cnt[1] += Integer.parseInt(token);
            }
        }

        if (cnt[0] == 0) {
            return "" + cnt[1];
        } else if (cnt[1] == 0) {
            return (cnt[0] == 1 ? "" : cnt[0]) + "x";
        } else {
            return (cnt[0] == 1 ? "" : cnt[0]) + "x + " + cnt[1];
        }
    }
}
