package day_31.SWEA_D2_1954;

import java.util.Scanner;

public class Solution {

    static int nr = 0;     // 새로 이동할 행 좌표
    static int nc = 0;     // 새로 이동할 열 좌표
    static int dir = 0;    // 이동 방향

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++) {

            int N = sc.nextInt();
            int[][] snail = new int[N][N];    // 달팽이 배열 선언
            int num = N * N;                  // 안에서 부터 밖으로 채워나갈 예정
            if(N%2 == 1){                     // N이 홀수일 때 시작할 준비
                nr = N / 2;
                nc = N / 2;
                dir = -1;
            }
            else{                             // N이 짝수일 때 시작할 준비
                nr = N / 2;
                nc = N / 2 - 1;
                dir = 1;
            }
            int step = 1;                     // 이동할 칸 수

            snail[nr][nc] = num--;            // 일단 하나 박아주기

            while(num > 0){

                for(int i=0 ; i<step ; i++){
                    snail[nr][nc+dir] = num--;    // 다음 칸 채워주기
                    if(num == 0){
                        break;                    // 무조건 행 순회에서 배열 끝남
                    }
                    nc += dir;                    // 좌표 갱신
                }

                if(num == 0){
                    break;                        // while 문 한번에 탈출 못해서 써줌(break out인가 뭐 있었는데 까먹음)
                }
                dir *= -1;                        // 방향 바꾸기

                for(int i=0 ; i<step ; i++){
                    snail[nr+dir][nc] = num--;    // 다음 칸 채워주기
                    nr += dir;                    // 좌표 갱신
                }

                step++;                           // 두번 방향 바꿀 때마다 이동할 칸이 한 칸씩 늘어남

            }
            printSnail(snail, tc);
        }
        sc.close();
    }

    public static void printSnail(int[][] arr, int N){    // 배열 출력 메소드
        System.out.printf("#%d\n", N);
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}