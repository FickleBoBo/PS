package day_28.prms_120850;

import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) list.add(c - '0');
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
