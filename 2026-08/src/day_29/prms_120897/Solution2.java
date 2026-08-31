package day_29.prms_120897;

import java.util.*;

class Solution2 {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) list.add(n / i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
