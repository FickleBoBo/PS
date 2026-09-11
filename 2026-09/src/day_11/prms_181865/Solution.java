package day_11.prms_181865;

import java.util.*;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        return a * b;
    }
}
