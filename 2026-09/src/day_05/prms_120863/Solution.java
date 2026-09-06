package day_05.prms_120863;

import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial);
        int[] cnt = {0, 0};

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("+")) continue;

            if (s.endsWith("x")) {
                if (s.length() == 1) {
                    cnt[0]++;
                } else {
                    cnt[0] += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                cnt[1] += Integer.parseInt(s);
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
