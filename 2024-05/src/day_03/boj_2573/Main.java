package day_03.BOJ_G4_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine() + " ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(true){
            int cnt = 0;
            visited = new boolean[N][M];
            for(int i=1 ; i<N-1 ; i++){
                for(int j=1 ; j<M-1 ; j++){
                    if(!visited[i][j] && map[i][j]>0){
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            if(cnt >= 2) break;
            if(cnt == 0){
                ans = 0;
                break;
            }
            ans++;

            meltDown();
//            printMap();
        }

        System.out.println(ans);

        br.close();
    }

    private static void printMap(){
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void meltDown() {
        copyMap = map.clone();
        for(int i=1 ; i<N-1 ; i++){
            copyMap[i] = map[i].clone();
        }

        for(int i=1 ; i<N-1 ; i++){
            for(int j=1 ; j<M-1 ; j++){
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if(map[nr][nc] == 0){
                        copyMap[i][j]--;
                    }
                }
                copyMap[i][j] = Math.max(copyMap[i][j], 0);
            }
        }

        map = copyMap;
    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(!visited[nr][nc] && map[nr][nc] > 0){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

}
