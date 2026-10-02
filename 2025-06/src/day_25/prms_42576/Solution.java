package day_25.PRMS_42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        // 동명이인 체크를 위해 해시맵 사용
        Map<String, Integer> map = new HashMap<>();

        // 참여한 선수 추가
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        // 완주한 선수 제외
        for (String person : completion) {
            map.put(person, map.get(person) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        // 실제로 불가능한 상황
        return null;
    }
}
