package day_25.PRMS_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 같은 이름을 가진 의상이 없으니 의상 종류별 의상 수만 계산
        for (String[] row : clothes) {
            map.put(row[1], map.getOrDefault(row[1], 0) + 1);
        }

        // 서로 다른 옷의 조합은 각 종류별로 의상을 선택하는 경우의 수의 곱으로 계산(해당 의상을 안입는 경우 포함)
        int answer = 1;
        for (int value : map.values()) {
            answer *= value + 1;
        }

        // 모든 의상을 안입는 1가지 경우 제외
        return answer - 1;
    }
}
