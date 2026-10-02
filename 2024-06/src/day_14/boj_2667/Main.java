package day_14.BOJ_S1_2667;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력 받아서 처리하기
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        // 단지내 집의 수를 오름차순으로 저장하는 PriorityQueue
        PriorityQueue<Integer> ansList = new PriorityQueue<>();

        // BFS를 통해 단지 내의 집의 수를 구하고 ansList에 추가해줌
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(map[i][j] == '1'){
                    int cnt = BFS(i, j);
                    ansList.offer(cnt);
                }
            }
        }

        // ansList의 크기가 단지의 수
        sb.append(ansList.size()).append("\n");
        while(!ansList.isEmpty()){
            sb.append(ansList.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        map[r][c] = '0';    // 원본 맵을 수정해서 방문체크
        int cnt = 1;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<N && (map[nr][nc]=='1')){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = '0';
                    cnt++;
                }
            }

        }

        return cnt;
    }
}
