package day_20.prms_181851;

import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) list.add(new int[]{rank[i], i});
        }
        list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));

        return 10_000 * list.get(0)[1] + 100 * list.get(1)[1] + list.get(2)[1];
    }
}
