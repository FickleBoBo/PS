package day_20.prms_181855;

import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[1 + 30];
        for (String s : strArr) {
            cnt[s.length()]++;
        }

        return Arrays.stream(cnt).max().getAsInt();
    }
}
