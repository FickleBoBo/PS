package day_14.BOJ_S1_2583;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // <그림>을 시계 방향으로 90도 돌려서 생각
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for(int k=0 ; k<K ; k++){
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            // 직사각형 좌표에 주의
            for(int i=startR ; i<endR ; i++){
                for(int j=startC ; j<endC ; j++){
                    map[i][j] = true;
                }
            }
        }

        // 오름차순으로 정렬해서 출력이라 우선순위 큐 사용
        PriorityQueue<Integer> ans = new PriorityQueue<>();

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(!map[i][j]){
                    int area = BFS(i, j);
                    ans.offer(area);
                }
            }
        }

        sb.append(ans.size()).append("\n");
        while(!ans.isEmpty()){
            sb.append(ans.poll()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        map[r][c] = true;    // 원본 맵을 수정해서 방문체크
        int cnt = 1;    // Queue에 담은 노드의 개수

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<M && (!map[nr][nc])){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = true;
                    cnt++;
                }
            }

        }

        return cnt;
    }

}
