package day_10.PRMS_138476;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        // key: 귤의 크기
        // value: 귤의 개수
        for (int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }

        // 개수를 기준 내림차순으로 정렬된 리스트로 변환
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> Integer.compare(o2, o1));

        int cnt = 0;
        for (int tang : list) {
            k -= tang;
            cnt++;

            if (k <= 0) break;
        }

        return cnt;
    }
}
