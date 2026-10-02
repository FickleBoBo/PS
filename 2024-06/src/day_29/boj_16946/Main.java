package day_29.BOJ_G2_16946;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 덧셈 연산을 위해 int[][] 배열로 초기화
        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            char[] input = br.readLine().toCharArray();

            for(int j=0 ; j<M ; j++){
                map[i][j] = input[j] - '0';
            }
        }

        visited = new boolean[N][M];

        // 방문안한 칸에 대해 BFS
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(!visited[i][j] && map[i][j]==0){
                    BFS(i, j);
                }
            }
        }

        // 조건 맞춰서 출력
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                sb.append(map[i][j] % 10);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 해당 위치에서 방문 가능한 칸의 개수를 세고 인접한 벽을 Queue에 담았다가 전부 갱신
    private static void BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        // 인접한 벽들을 담는 Queue
        Queue<int[]> walls = new ArrayDeque<>();

        // 해당 위치에서 방문 가능한 칸의 개수
        int cnt = 1;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]){
                    // 방문 가능한 칸이면 Queue에 담음
                    if(map[nr][nc] == 0){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        cnt++;
                    }
                    // 벽이면 따로 Queue에 담고 방문 체크
                    else{
                        walls.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

        }

        // 벽들을 전부 꺼내면서 갱신해주고 방문 체크를 풀어줌
        while(!walls.isEmpty()){
            int[] node = walls.poll();

            int wr = node[0];
            int wc = node[1];

            map[wr][wc] += cnt;
            visited[wr][wc] = false;
        }
    }

}
