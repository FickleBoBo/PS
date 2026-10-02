# [PRMS 42576 - 완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576)

## 문제 설명

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를
작성해주세요.

## 제한사항

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.

## 입출력 예

| participant                                       | completion                               | return   |
|---------------------------------------------------|------------------------------------------|----------|
| ["leo", "kiki", "eden"]                           | ["eden", "kiki"]                         | "leo"    |
| ["marina", "josipa", "nikola", "vinko", "filipa"] | ["josipa", "filipa", "marina", "nikola"] | "vinko"  |
| ["mislav", "stanko", "mislav", "ana"]             | ["stanko", "ana", "mislav"]              | "mislav" |

## 입출력 예 설명

예제 #1

"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2

"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3

"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

---

## 문제 정보

| 티어  | Lv. 1 |
|-----|-------|
| 정답률 | 58%   |

## 풀이 정보

| 풀이 시간 | 13 min |
|-------|--------|
| 알고리즘  | 해시맵    |

| 정확성 테스트                     |
|-----------------------------|
| 테스트 1 〉 통과 (0.11ms, 85.5MB) |
| 테스트 2 〉 통과 (0.10ms, 85.2MB) |
| 테스트 3 〉 통과 (0.47ms, 77.4MB) |
| 테스트 4 〉 통과 (1.37ms, 75.9MB) |
| 테스트 5 〉 통과 (0.76ms, 73.7MB) |
| 테스트 6 〉 통과 (0.04ms, 78.4MB) |
| 테스트 7 〉 통과 (0.06ms, 85MB)   |

| 효율성 테스트                      |
|------------------------------|
| 테스트 1 〉 통과 (36.40ms, 92.8MB) |
| 테스트 2 〉 통과 (62.40ms, 95.1MB) |
| 테스트 3 〉 통과 (74.81ms, 96.3MB) |
| 테스트 4 〉 통과 (76.09ms, 112MB)  |
| 테스트 5 〉 통과 (83.37ms, 97.3MB) |

## 코드

```java
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
```

## 리뷰

- Entry 관련 코드 사용이 오랜만이라 기억이 안나서 조금 걸렸다.
