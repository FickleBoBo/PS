package day_12.prms_181862;

import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        StringTokenizer st = new StringTokenizer(myStr, "abc");
        if (!st.hasMoreTokens()) return new String[]{"EMPTY"};

        String[] arr = new String[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }

        return arr;
    }
}
