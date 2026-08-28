package day_28.prms_120852;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int x = 2;

        while (n > 1) {
            if (n % x == 0) {
                list.add(x);
                while (n % x == 0) {
                    n /= x;
                }
                continue;
            }

            x++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
