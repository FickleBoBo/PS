package day_25.prms_12906;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int x : arr) {
            if (dq.isEmpty() || dq.peekLast() != x) dq.offerLast(x);
        }

        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}
