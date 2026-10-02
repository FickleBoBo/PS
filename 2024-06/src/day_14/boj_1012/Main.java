package day_14.BOJ_S2_1012;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int M;
    static int N;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        // 입력값이 가로가 먼저오는데 가로세로를 바꿔도 논리에는 문제없음
        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 배추가 심어진 곳을 true로 하는 boolean[][] 타입으로 만들어서 방문체크까지 진행
            map = new boolean[M][N];
            for(int i=0 ; i<K ; i++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            int cnt = 0;
            for(int i=0 ; i<M ; i++){
                for(int j=0 ; j<N ; j++){
                    if(map[i][j]){

                        // 배추흰지렁이 투입
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        map[r][c] = false;    // 원본 맵을 수정해서 방문체크

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<M && nc>=0 && nc<N && map[nr][nc]){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = false;
                }
            }

        }
    }

}
