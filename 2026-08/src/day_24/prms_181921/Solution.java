package day_24.prms_181921;

import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (check(i)) list.add(i);
        }

        if (list.isEmpty()) return new int[]{-1};
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean check(int x) {
        while (x > 0) {
            int d = x % 10;
            if (d != 0 && d != 5) return false;
            x /= 10;
        }

        return true;
    }
}
