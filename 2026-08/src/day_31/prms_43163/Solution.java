package day_31.prms_43163;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> dict = new HashSet<>(List.of(words));

        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);

        Set<String> vis = new HashSet<>();
        vis.add(begin);

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                String cur = q.poll();
                if (cur.equals(target)) return dist;

                for (int i = 0; i < cur.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String nxt = cur.substring(0, i) + c + cur.substring(i + 1);
                        if (!dict.contains(nxt) || vis.contains(nxt)) continue;

                        q.offer(nxt);
                        vis.add(nxt);
                    }
                }
            }

            dist++;
        }

        return 0;
    }
}
