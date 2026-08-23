package day_24.prms_181921;

import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (func(i)) list.add(i);
        }

        if (list.isEmpty()) return new int[]{-1};
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean func(int x) {
        while (x > 0) {
            int r = x % 10;
            if (r != 0 && r != 5) return false;
            x /= 10;
        }

        return true;
    }
}
