package day_12.BOJ_S1_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static String[][] miro;
    static boolean[][] visited;
    static int[][] timeTable;    // 시작점에서 해당 위치까지의 최단거리 기록

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        miro = new String[N][M];
        visited = new boolean[N][M];
        timeTable = new int[N][M];
        for(int i=0 ; i<N ; i++){
            miro[i] = br.readLine().split("");
        }

        BFS(new int[] {0, 0});
        System.out.println(timeTable[N-1][M-1]);    // 미로의 끝에 해당하는 최단 거리 출력
        br.close();
    }

    private static void BFS(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        timeTable[start[0]][start[1]] = 1;

        while(!q.isEmpty()){
            int[] pos = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = pos[0] + dr[dir];
                int nc = pos[1] + dc[dir];
                if((nr>=0) && (nc>=0) && (nr<N) && (nc<M) && (!visited[nr][nc]) && (miro[nr][nc].equals("1"))){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    timeTable[nr][nc] = timeTable[pos[0]][pos[1]] + 1;
                }
            }
        }
    }

}
