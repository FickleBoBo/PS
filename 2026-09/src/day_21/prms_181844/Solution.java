package day_21.prms_181844;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean[] seen = new boolean[1 + 1000];
        for (int x : delete_list) {
            seen[x] = true;
        }

        return Arrays.stream(arr).filter(x -> !seen[x]).toArray();
    }
}
