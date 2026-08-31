package day_28.prms_120888;

import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : my_string.toCharArray()) {
            if (seen.add(c)) sb.append(c);
        }

        return sb.toString();
    }
}
