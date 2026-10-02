package day_10.BOJ_S4_1388;

import java.util.Scanner;

public class Main_DFS {

    static int N;
    static int M;
    static char[][] floor;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) {

        // step1 - 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        floor = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0 ; i<N ; i++){
            floor[i] = sc.next().toCharArray();
        }

        // step2 - 바닥을 돌며 DFS
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(!visited[i][j]){
                    cnt++;
                    DFS(i, j, floor[i][j]);
                }
            }
        }

        System.out.println(cnt);
        sc.close();

    }

    private static void DFS(int r, int c, char pattern) {
        // 방문 체크
        visited[r][c] = true;

        // 바닥 모양에 따라 다음 칸 위치 갱신
        if(pattern == '-') c++;
        else r++;

        // 다음 칸이 바닥 안이면서 같은 패턴이면 DFS 돌기
        if((r<N) && (c < M) && (floor[r][c] == pattern)){
            DFS(r, c, pattern);
        }
    }

}
