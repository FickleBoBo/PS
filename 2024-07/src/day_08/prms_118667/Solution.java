package day_08.PGMS_LV2_두_큐_합_같게_만들기;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        // Queue 선언
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        // Queue로 바꾸고 각 Queue의 원소의 합 저장
        long sum1 = 0;
        for(int n : queue1) { q1.offer(n); sum1 += n; }
        long sum2 = 0;
        for(int n : queue2) { q2.offer(n); sum2 += n; }

        // 작업 횟수
        int cnt = 0;

        // 두 큐의 합을 같게 만들 수 있으면 true, 없으면 false
        boolean flag = true;

        while(true){
            // 한 쪽 큐가 빌 때까지 이동하는 상황이면 불가능한 원소 조합
            // 이유는 잘 모르겠는데 모든 원소의 총합의 절반보다 큰 원소가 있어야만 가능한 경우로 예상(예제 3번 케이스)?
            if(q1.isEmpty() || q2.isEmpty()){
                flag = false;
                break;
            }

            // 이거 없으면 테스트 케이스 11번, 28번 시간초과나는데 느낌이 딱 무한루프
            // cnt의 상한이 얼마인지는 잘 모르겠음
            if(cnt > (q1.size() + q2.size()) * 2){
                flag = false;
                break;
            }

            // 큐1의 총합이 더 크면 큐1에서 큐2로 하나 옮김
            if(sum1 > sum2){
                int n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.offer(n);
                cnt++;
            }
            // 큐2의 총합이 더 크면 큐2에서 큐1로 하나 옮김
            else if(sum1 < sum2){
                int n = q2.poll();
                sum1 += n;
                sum2 -= n;
                q1.offer(n);
                cnt++;
            }
            // 두 큐의 합이 같으면 종료
            else{
                break;
            }
        }

        // 두 큐의 합을 같게 만들 수 있으면 cnt, 없으면 -1 출력
        int answer = flag ? cnt : -1;
        return answer;
    }
}

// 테스트 1 〉	통과 (0.09ms, 75.5MB)
// 테스트 2 〉	통과 (0.03ms, 75.1MB)
// 테스트 3 〉	통과 (0.06ms, 76.4MB)
// 테스트 4 〉	통과 (0.11ms, 76.4MB)
// 테스트 5 〉	통과 (0.41ms, 66.3MB)
// 테스트 6 〉	통과 (0.33ms, 74.2MB)
// 테스트 7 〉	통과 (0.35ms, 73.1MB)
// 테스트 8 〉	통과 (0.42ms, 76.8MB)
// 테스트 9 〉	통과 (0.56ms, 75.4MB)
// 테스트 10 〉	통과 (1.11ms, 77.8MB)
// 테스트 11 〉	통과 (24.71ms, 103MB)
// 테스트 12 〉	통과 (16.74ms, 107MB)
// 테스트 13 〉	통과 (12.08ms, 93.2MB)
// 테스트 14 〉	통과 (11.34ms, 90.7MB)
// 테스트 15 〉	통과 (18.39ms, 105MB)
// 테스트 16 〉	통과 (16.80ms, 103MB)
// 테스트 17 〉	통과 (26.63ms, 101MB)
// 테스트 18 〉	통과 (26.63ms, 126MB)
// 테스트 19 〉	통과 (35.10ms, 120MB)
// 테스트 20 〉	통과 (54.15ms, 126MB)
// 테스트 21 〉	통과 (41.72ms, 125MB)
// 테스트 22 〉	통과 (45.96ms, 127MB)
// 테스트 23 〉	통과 (60.72ms, 136MB)
// 테스트 24 〉	통과 (47.45ms, 141MB)
// 테스트 25 〉	통과 (0.39ms, 73.4MB)
// 테스트 26 〉	통과 (0.24ms, 75.7MB)
// 테스트 27 〉	통과 (0.25ms, 76.1MB)
// 테스트 28 〉	통과 (40.72ms, 114MB)
// 테스트 29 〉	통과 (2.50ms, 70.5MB)
// 테스트 30 〉	통과 (32.58ms, 106MB)
