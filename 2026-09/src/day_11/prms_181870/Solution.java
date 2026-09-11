package day_11.prms_181870;

import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for (String s : strArr) {
            if (s.contains("ad")) continue;
            list.add(s);
        }

        return list.toArray(new String[0]);
    }
}
