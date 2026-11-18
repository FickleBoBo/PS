package day_17.prms_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        for (int[] c : commands) {
            int i = c[0], j = c[1], k = c[2];
            int[] tmp = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(tmp);
            ans.add(tmp[k - 1]);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
