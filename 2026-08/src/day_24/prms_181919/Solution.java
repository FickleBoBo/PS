package day_24.prms_181919;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            list.add(n);
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
        }
        list.add(n);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
