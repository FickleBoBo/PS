package day_07.PGMS_LV2_귤_고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        // key : 귤의 무게
        // value : 귤의 개수
        // 귤의 무게 범위가 넓어서 카운팅 배열로 힘들거 같음
        Map<Integer, Integer> cntMap = new HashMap<>();

        // 귤 배열에서 카운팅 맵으로 알맞게 집어넣기
        for(int tang : tangerine){
            cntMap.put(tang, cntMap.getOrDefault(tang, 0) + 1);
        }

        // cntMap.values()는 hashMap의 value들을 Collection 타입으로 반환하는 메서드
        // PriorityQueue는 생성자에 Collection 받을 수 있음
        PriorityQueue<Integer> pq = new PriorityQueue(cntMap.values());

        // 귤의 전체 개수에서 역으로 찾아줌(cntMap.values()랑 Collections.reverseOrder()를 같이 못써서 이렇게 함)
        // 개수가 적은 무게부터 빼주면서 찾으나 개수가 많은 무게부터 담으나 결국 똑같음
        int ans = cntMap.size();        // 박스에 담은 귤의 종류
        int left = tangerine.length;    // 남은 귤의 개수

        while(!pq.isEmpty()){
            left -= pq.poll();    // 같은 무게 개수 적은 귤 없애고
            ans--;                // 귤의 종류 하나 빼줌

            if(k > left) break;    // 남은 귤이 k개보다 적으면 끝
        }

        return ans + 1;    // 사실 남은 귤이 k개 이상이어야 하니 귤 종류 하나 더 있어야 함
    }
}

// 테스트 1 〉통과 (21.43ms, 82.8MB)
// 테스트 2 〉통과 (28.63ms, 96.6MB)
// 테스트 3 〉통과 (15.94ms, 93.2MB)
// 테스트 4 〉통과 (25.29ms, 95.5MB)
// 테스트 5 〉통과 (17.30ms, 88.9MB)
// 테스트 6 〉통과 (28.63ms, 96.8MB)
// 테스트 7 〉통과 (15.51ms, 87.8MB)
// 테스트 8 〉통과 (19.19ms, 87.8MB)
// 테스트 9 〉통과 (20.29ms, 93.4MB)
// 테스트 10 〉통과 (26.94ms, 88.2MB)
// 테스트 11 〉통과 (0.48ms, 81.7MB)
// 테스트 12 〉통과 (0.53ms, 74MB)
// 테스트 13 〉통과 (0.48ms, 71.9MB)
// 테스트 14 〉통과 (0.49ms, 77.4MB)
// 테스트 15 〉통과 (0.55ms, 80.8MB)
// 테스트 16 〉통과 (0.43ms, 68.9MB)
// 테스트 17 〉통과 (0.44ms, 71.4MB)
// 테스트 18 〉통과 (0.56ms, 72.9MB)
// 테스트 19 〉통과 (0.51ms, 71.5MB)
// 테스트 20 〉통과 (0.57ms, 76.2MB)
// 테스트 21 〉통과 (1.35ms, 79.8MB)
// 테스트 22 〉통과 (2.19ms, 83.9MB)
// 테스트 23 〉통과 (2.40ms, 76.1MB)
// 테스트 24 〉통과 (1.80ms, 75.8MB)
// 테스트 25 〉통과 (16.95ms, 93.4MB)
// 테스트 26 〉통과 (15.78ms, 79.5MB)
// 테스트 27 〉통과 (43.42ms, 102MB)
// 테스트 28 〉통과 (41.62ms, 90.2MB)
// 테스트 29 〉통과 (37.41ms, 98.3MB)
// 테스트 30 〉통과 (69.81ms, 105MB)
// 테스트 31 〉통과 (19.64ms, 87.6MB)
// 테스트 32 〉통과 (16.63ms, 86.3MB)
// 테스트 33 〉통과 (40.88ms, 97.3MB)
// 테스트 34 〉통과 (43.70ms, 84.9MB)
