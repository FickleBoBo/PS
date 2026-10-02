package day_26.BOJ_G4_14502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] map;        // map : 연구소 원본
    static int[][] mapCopy;    // mapCopy : 연구소 복사본(재귀용)
    static int N;              // N : 연구소 세로 크기(행)
    static int M;              // M : 연구소 가로 크기(열)
    static int ans = 0;        // 안전 영역의 크기

    // mapCopy로 map의 정보를 복사하는 메서드
    static void copyOriginMap(){
        for(int i=0 ; i<map.length ; i++){
            mapCopy[i] = Arrays.copyOf(map[i], map[0].length);    // 2차원 배열이라 한 줄씩 복사해야됨(+범위 주의)
        }
    }

    // 복사본 연구소를 감염시키는 재귀 메서드(효율성은 상당히 떨어져보임)
    static void virusInfection(){
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                if(mapCopy[i][j] == 2){    // 복사본 연구소를 돌며 바이러스를 발견하면
                    if(mapCopy[i-1][j] == 0){    // 위쪽이 빈 칸이면 감염시키고 재귀
                        mapCopy[i-1][j] = 2;
                        virusInfection();
                    }
                    if(mapCopy[i][j+1] == 0){    // 오른쪽이 빈 칸이면 감염시키고 재귀
                        mapCopy[i][j+1] = 2;
                        virusInfection();
                    }
                    if(mapCopy[i+1][j] == 0){    // 아래쪽이 빈 칸이면 감염시키고 재귀
                        mapCopy[i+1][j] = 2;
                        virusInfection();
                    }
                    if(mapCopy[i][j-1] == 0){    // 왼쪽이 빈 칸이면 감염시키고 재귀
                        mapCopy[i][j-1] = 2;
                        virusInfection();
                    }
                }
            }
        }
    }

    // 주어진 3개의 좌표에 벽을 세우고 안전 영역을 계산하는 핵심 메서드
    static void makeWall(int r1, int c1, int r2, int c2, int r3, int c3){
        copyOriginMap();        // 새롭게 복사본 연구소 생성(원본에 재귀 돌리면 복구가 안됨)
        mapCopy[r1][c1] = 1;    // 첫번째 벽 세우기
        mapCopy[r2][c2] = 1;    // 두번째 벽 세우기
        mapCopy[r3][c3] = 1;    // 세번째 벽 세우기

        virusInfection();       // 감염시키기
        countSafeZone();        // 감염시킨 후 안전영역 갱신
    }

    // 감염된 연구소에서 안전영역을 갱신하는 메서드(안전 영역을 static 변수로 만들어서 리턴 없어도 됨)
    static void countSafeZone(){
        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                if(mapCopy[i][j] == 0) cnt++;
            }
        }
        ans = ans > cnt ? ans : cnt;
    }

    public static void main(String[] args) {

        // step1 : 마구마구 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[1+N+1][1+M+1];    // 상하좌우 패딩을 벽(1)으로 줘서 인덱스 조건 편하게 함
        mapCopy = new int[1+N+1][1+M+1];
        for(int i=0 ; i<N+2 ; i++){    // 일단 전부 벽으로 채우기
            Arrays.fill(map[i], 1);
        }

        List<int[]> blank = new ArrayList<>();    // 빈칸의 좌표를 배열로 저장할 어레이 리스트

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                map[i][j] = sc.nextInt();    // 연구소 정보를 입력 받음
                if(map[i][j] == 0){
                    int[] tmp = {i, j};
                    blank.add(tmp);    // 연구소 정보를 받은 후 빈 칸의 좌표만 blank에 저장
                }
            }
        }

        // 전체 빈칸 중 벽을 세울 3곳을 뽑는 조합이므로 3중 for문으로 모든 경우의 수를 탐색
        for(int i=0 ; i<blank.size()-2 ; i++){
            for(int j=i+1 ; j<blank.size()-1 ; j++){
                for(int k=j+1 ; k<blank.size() ; k++){
                    // 벽세우고 휘바휘바
                    makeWall(blank.get(i)[0], blank.get(i)[1], blank.get(j)[0], blank.get(j)[1], blank.get(k)[0], blank.get(k)[1]);
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
