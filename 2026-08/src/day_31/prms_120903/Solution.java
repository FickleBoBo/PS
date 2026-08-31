package day_31.prms_120903;

import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> seen = new HashSet<>(List.of(s1));
        int cnt = 0;

        for (String s : s2) {
            if (seen.contains(s)) cnt++;
        }

        return cnt;
    }
}
