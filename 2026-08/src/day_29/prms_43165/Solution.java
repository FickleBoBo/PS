package day_29.prms_43165;

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        for (int x : numbers) {
            int sz = q.size();
            while (sz-- > 0) {
                int cur = q.poll();
                q.offer(cur + x);
                q.offer(cur - x);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            if (q.poll() == target) cnt++;
        }

        return cnt;
    }
}
