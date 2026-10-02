package day_12.SWEA_D3_1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                 // T : 테스트 케이스의 수

        for (int tc = 1; tc <= T; tc++) {     // tc : 각각의 테스트 케이스
            boolean possible = true;          // possible : 한번만 붕어빵이 모자라도 바로 false로 바꿀 flag
            int N = sc.nextInt();             // N : 손님의 수
            int M = sc.nextInt();             // M : 붕어빵 생산 시간
            int K = sc.nextInt();             // K : 붕어빵 생산 개수
            int[] waitingArr = new int[N];    // waitingArr : 손님이 오는 시간을 배열에 저장

            for (int i = 0; i < N; i++) {
                waitingArr[i] = sc.nextInt();
            }
            Arrays.sort(waitingArr);                                  // 정렬을 해주면 가장 마지막 인덱스의 값이 손님이 가장 늦게 오는 시간

            int[] timeLine = new int[waitingArr[N - 1] + 1];          // timeLine : 손님과 붕어빵 상태를 저장할 배열
            int[] timeLinePrefix = new int[waitingArr[N - 1] + 1];    // timeLinePrefix : 붕어빵 재고(누적합)
            for (int i = 0; i < N; i++) {
                timeLine[waitingArr[i]] -= 1;                         // 손님이 붕어빵 하나를 사가니 빼줌(카운팅 배열)
            }
            timeLinePrefix[0] = timeLine[0];                          // 이거 넣어서 테스트 케이스 993 -> 997 (0초일 때 손님온다)
            if (timeLinePrefix[0] < 0) {                              // 이거 넣어서 테스트 케이스 997 -> 1000 (0초일때 손님오면 바로 나가리) 위에꺼로 4개 더 통과한거는 거의 무의미인듯
                possible = false;
            }

            for (int i = 1; i < timeLine.length; i++) {                     // 타임라인 동안 반복
                if (i % M == 0) {                                           // 붕어빵이 나올 때
                    timeLine[i] += K;                                       // 붕어빵 생산량을 더해줌
                }
                timeLinePrefix[i] = timeLine[i] + timeLinePrefix[i - 1];    // 붕어빵 재고 갱신
                if (timeLinePrefix[i] < 0) {                                // 붕어빵이 모자랄때
                    possible = false;
                    break;
                }
            }

            if (possible) System.out.printf("#%d Possible\n", tc);
            else System.out.printf("#%d Impossible\n", tc);
        }
        sc.close();
    }
}
