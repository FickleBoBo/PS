package day_15.BOJ_G5_10026;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 사람
        visited = new boolean[N][N];
        int cntNormal = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(!visited[i][j]){
                    BFSNormal(i, j);
                    cntNormal++;
                }
            }
        }

        // 적록색약인 사람
        visited = new boolean[N][N];
        int cntDisabled = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(!visited[i][j]){
                    BFSDisabled(i, j);
                    cntDisabled++;
                }
            }
        }

        System.out.println(cntNormal + " " + cntDisabled);
    }

    private static void BFSNormal(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && (map[r][c]==map[nr][nc])){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

        }
    }

    private static void BFSDisabled(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){

                    // 이 조건 부분만 달라지는 것으로 파랑끼리 이어주거나 파랑이 아닌것끼리 이어주면 된다
                    if(((map[r][c]=='B') && (map[nr][nc]=='B')) || ((map[r][c]!='B') && (map[nr][nc]!='B'))){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

        }
    }

}
