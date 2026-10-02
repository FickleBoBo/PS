package day_10.PRMS_118667;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int item : queue1) {
            sum1 += item;
            q1.add(item);
        }

        for (int item : queue2) {
            sum2 += item;
            q2.add(item);
        }

        // 최대 시행 횟수로 모든 원소가 이동 후 제자리로 올 때까지 각 큐의 원소의 합이 같지 않으면 불가능한 조합
        int max = 2 * (q1.size() + q2.size());
        for (int i = 0; i < max; i++) {
            if (sum1 > sum2) {
                int item = q1.remove();
                q2.add(item);
                sum1 -= item;
                sum2 += item;
            } else if (sum1 < sum2) {
                int item = q2.remove();
                q1.add(item);
                sum1 += item;
                sum2 -= item;
            } else {
                return i;
            }
        }

        return -1;
    }
}
