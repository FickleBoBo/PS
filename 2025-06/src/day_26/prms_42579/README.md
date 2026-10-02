# [PRMS 42579 - 베스트앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579)

## 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

## 제한사항

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

## 입출력 예

| genres                                          | plays                      | return       |
| ----------------------------------------------- | -------------------------- | ------------ |
| ["classic", "pop", "classic", "classic", "pop"] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

## 입출력 예 설명

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

- 고유 번호 3: 800회 재생
- 고유 번호 0: 500회 재생
- 고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

- 고유 번호 4: 2,500회 재생
- 고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

- 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

---

## 문제 정보

| 티어   | Lv. 3 |
| ------ | ----- |
| 정답률 | 55%   |

## 풀이 정보

| 풀이 시간 | 44 min              |
| --------- | ------------------- |
| 알고리즘  | 해시맵, 우선순위 큐 |

| 정확성 테스트                      |
| ---------------------------------- |
| 테스트 1 〉 통과 (2.15ms, 80.5MB)  |
| 테스트 2 〉 통과 (1.50ms, 87.7MB)  |
| 테스트 3 〉 통과 (1.72ms, 92.7MB)  |
| 테스트 4 〉 통과 (1.45ms, 81MB)    |
| 테스트 5 〉 통과 (2.42ms, 75.5MB)  |
| 테스트 6 〉 통과 (2.31ms, 91.4MB)  |
| 테스트 7 〉 통과 (1.53ms, 75.2MB)  |
| 테스트 8 〉 통과 (1.59ms, 75.2MB)  |
| 테스트 9 〉 통과 (1.64ms, 91.5MB)  |
| 테스트 10 〉 통과 (1.83ms, 97.5MB) |
| 테스트 11 〉 통과 (1.68ms, 83.9MB) |
| 테스트 12 〉 통과 (1.64ms, 90.5MB) |
| 테스트 13 〉 통과 (1.64ms, 78.6MB) |
| 테스트 14 〉 통과 (1.71ms, 88MB)   |
| 테스트 15 〉 통과 (1.53ms, 87.4MB) |

## 코드

```java
import java.util.*;

class Solution {

    // 노래 통계 클래스
    private static class MusicStat implements Comparable<MusicStat> {
        String genre;
        int play;

        public MusicStat(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(MusicStat o) {
            return Integer.compare(o.play, this.play);
        }
    }

    // 노래 클래스
    private static class Music implements Comparable<Music> {
        int id;
        String genre;
        int play;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(o.play, this.play);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;

        // key: 장르, value: 장르의 전체 재생된 횟수
        Map<String, Integer> statMap = new HashMap<>();

        // key: 장르, value: 장르별 노래 클래스를 담은 우선순위 큐
        Map<String, PriorityQueue<Music>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String genre = genres[i];
            int play = plays[i];

            statMap.put(genre, statMap.getOrDefault(genre, 0) + play);

            map.putIfAbsent(genre, new PriorityQueue<>());
            map.get(genre).add(new Music(i, genre, play));
        }

        // 노래 통계를 재생된 횟수에 대한 내림차순을 구하기 위해 우선순위 큐 사용
        PriorityQueue<MusicStat> statPq = new PriorityQueue<>();
        statMap.forEach((k, v) -> statPq.add(new MusicStat(k, v)));

        List<Integer> list = new ArrayList<>();
        while (!statPq.isEmpty()) {
            String genre = statPq.remove().genre;

            PriorityQueue<Music> pq = map.get(genre);
            int cnt = 0;

            // 장르별 최대 2곡만 수록
            while (!pq.isEmpty()) {
                list.add(pq.remove().id);
                cnt++;

                if (cnt == 2) break;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
```

## 리뷰

- Map의 putIfAbsent와 forEach 메서드를 통해 보다 가독성 좋게 해결할 수 있었던 거 같다.
- 통계와 노래를 별도로 처리하는 방법만 떠올라서 약간 지저분해진 것 같다.
- stream을 통해 List -> Array를 간단하게 처리하는 방법이 있었는데 아직 충분히 이해되지 않는 것 같다.
