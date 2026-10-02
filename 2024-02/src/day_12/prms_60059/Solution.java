package day_12.KAKAO_2020_Lv3_자물쇠와열쇠;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {    // 샘플 케이스 테스트 용
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1},
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {       // 제출할 코드

        int M = key.length;                                           // 계산 편의를 위해 key의 길이를 받아놓음
        int N = lock.length;                                          // 계산 편의를 위해 lock의 길이를 받아놓음
        int[][] table = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];    // 상하좌우 패딩을 한 table을 생성



        /* 패딩한 table 초기화
         * 패딩 크기는 M-1 로 설정해서 무조건 key가 겹칠때만 고려
         * 상하좌우 모두 패딩이 들어가고 가운데는 lock의 데이터를 넣어야 함
         * for문의 범위 주의
         */
        for (int i = M - 1; i < N + M - 1; i++) {
            for (int j = M - 1; j < N + M - 1; j++) {
                table[i][j] = lock[i - M + 1][j - M + 1];
            }
        }
//        print2DArr(table);



        /* 메인 코드
         * 열쇠의 회전을 고려해야 하므로 rotation 변수를 선언하고 while문 조건을 통해 3번 회전할 때까지 탐색
         */
        int rotation = 4;
        while (rotation-- != 0) {

            /* 처음 두 개의 for문은 패딩한 테이블을 돌며 시작점을 찾는다
            * 다음 두 개의 for문은 시작점에서 열쇠의 값을 더해주는 작업을 한다
            * 이때 2차원 배열 복사 메소드로 독립적인 비교를 할 수 있게 한다(배열이 주소참소라서?)
            */
            for (int i = 0; i < N + M - 1; i++) {
                for (int j = 0; j < N + M - 1; j++) {
                    int[][] tmp = copy2DArr(table);
                    for (int a = 0; a < M; a++) {
                        for (int b = 0; b < M; b++) {
                            tmp[i + a][j + b] += key[a][b];
                        }
                    }

                    /* cnt로 key를 넣었을 때 전부 1이 되는지 확인
                    * 0이면 key의 홈이 부족하다는 것이고 2면 홈끼리 만나는 것이므로 둘다 바로 반복문 탈출
                    * key와 lock이 딱 맞물리면 true 리턴하고 종료
                    */
                    int cnt = N * N;
                    out:
                    for (int a = M - 1; a < N + M - 1; a++) {
                        for (int b = M - 1; b < N + M - 1; b++) {
                            if ((tmp[a][b] == 0) || (tmp[a][b] == 2)) {
                                break out;
                            } else {
                                cnt--;
                            }
                        }
                    }
//                    print2DArr(tmp);
                    if (cnt == 0) {
                        return true;
                    }
                }
            }
            key = rotationArr(key);    // 쭉 돌았을 때 문이 열리지 않으면 key를 돌려서 같은 작업 반복
        }
        return false;    // key를 돌려도 문이 열리지 않으면 false 리턴
    }

    public static void print2DArr(int[][] arr) {    // 한번에 구하려고 하면 에러 많이 나니까 미리 2차원 배열을 출력하는 메소드를 만들어서 확인
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] copy2DArr(int[][] arr) {    // 2차원 배열은 한번에 복사하는 메소드는 없는거 같아서 만듦
        int[][] tmp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = Arrays.copyOf(arr[i], arr.length);
        }
        return tmp;
    }

    public static int[][] rotationArr(int[][] arr) {    // 2차원 배열을 회전하는(90도) 메소드를 하나만 만들면 반복 호출로 쭉 회전 가능
        int[][] tmp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tmp[i][j] = arr[j][arr.length - 1 - i];
            }
        }
        return tmp;
    }

}
