package day_31.prms_120902;

import java.util.*;

class Solution {
    public int solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        int ans = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            if (op.equals("+")) {
                ans += Integer.parseInt(st.nextToken());
            } else {
                ans -= Integer.parseInt(st.nextToken());
            }
        }

        return ans;
    }
}
