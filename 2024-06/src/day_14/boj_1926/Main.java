package day_14.BOJ_S1_1926;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] == 1){
                    int area = BFS(i, j);
                    ans = Math.max(ans, area);    // 그림 넓이의 최댓값 갱신
                    cnt++;    // 그림의 개수 갱신
                }
            }
        }

        System.out.println(cnt);
        System.out.println(ans);
    }

    private static int BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        map[r][c] = 0;    // 원본 맵을 수정해서 방문체크
        int cnt = 1;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<M && (map[nr][nc]==1)){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = 0;
                    cnt++;
                }
            }

        }

        return cnt;
    }

}
