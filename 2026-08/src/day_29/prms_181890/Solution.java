package day_29.prms_181890;

import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int n = str_list.length;

        for (int i = 0; i < n; i++) {
            if (str_list[i].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, i);
            }
            if (str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i + 1, n);
            }
        }

        return new String[0];
    }
}
