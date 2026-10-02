package day_14.BOJ_S1_2468;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int maxHeight = 0;    // 지역 높이의 최댓값
        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int maxCnt = 0;    // 안전 영역 개수의 최댓값
        for(int k=0 ; k<maxHeight ; k++){
            int cnt = 0;    // 비가 k만큼 왔을 때 안전 영역의 개수

            visited = new boolean[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if((!visited[i][j]) && (map[i][j] > k)){
                        BFS(i, j, k);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }

    // 안전 영역의 개수를 구할 때 원본 맵을 1씩 감소시키는 것과 비의 높이를 1씩 증가시키는 것은 똑같음
    private static void BFS(int r, int c, int height){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<N && (!visited[nr][nc]) && (map[nr][nc]>height)){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

        }

    }

}
