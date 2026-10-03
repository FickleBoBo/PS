package day_28.prms_120853;

import java.util.*;

class Solution {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int sum = 0;
        int prv = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("Z")) {
                sum -= prv;
            } else {
                int x = Integer.parseInt(token);
                sum += x;
                prv = x;
            }
        }

        return sum;
    }
}
