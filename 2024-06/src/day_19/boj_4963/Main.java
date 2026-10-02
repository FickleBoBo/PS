package day_19.BOJ_S2_4963;

import java.io.*;
import java.util.*;

public class Main {

    // 팔방탐색 델타배열
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static int w;
    static int h;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            String input = br.readLine();
            if(input.charAt(0) == '0') break;    // 0 0 이 들어오면 종료

            st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[1+h+1][1+w+1];    // 맵의 상하좌우에 패딩을 주면 배열 경계조건 배제 가능

            for(int i=1 ; i<=h ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1 ; j<=w ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=1 ; i<=h ; i++){
                for(int j=1 ; j<=w ; j++){
                    if(map[i][j] == 1){    // 섬을 발견하면
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
        map[r][c] = 0;    // 원본 맵을 수정해서 방문체크(섬을 없애버림)

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<8 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(map[nr][nc] == 1){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = 0;
                }
            }

        }
    }

}
