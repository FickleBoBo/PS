package day_15.BOJ_G4_2573;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

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

        int year = 1;
        while(true){
            // 빙산을 녹이면서 녹았는지 여부를 flag에 저장
            boolean flag = afterMelted();

            // 빙산이 안녹았다는건 빙산이 다 녹아서 없는 것임
            if(!flag){
                System.out.println(0);
                break;
            }

            // 빙산에 대해 BFS를 통해 덩어리의 수를 구함
            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=1 ; i<N-1 ; i++){
                for(int j=1 ; j<M-1 ; j++){
                    if((!visited[i][j]) && (map[i][j]>0)){
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            // 빙산이 두 덩어리 이상이 되면 종료
            if(cnt >= 2){
                System.out.println(year);
                break;
            }

            year++;
        }
    }

    // 빙산을 녹이는 메서드로 임시 배열에 각 지점이 얼마나 녹아야 하는지 저장한 후 빼줌
    // 빙산을 녹이면서 BFS를 하면 방금 녹아서 0이 된 지점이 다음 칸에 영향을 미쳐서 안됨
    private static boolean afterMelted(){
        boolean flag = false;

        // 빙산의 각 지점과 대응되며 얼마나 녹아야 하는지 저장하는 2차원 배열
        int[][] diff = new int[N][M];

        for(int i=1 ; i<N-1 ; i++){
            for(int j=1 ; j<M-1 ; j++){
                if(map[i][j] > 0){
                    for(int dir=0 ; dir<4 ; dir++){
                        if(map[i+dr[dir]][j+dc[dir]] == 0){
                            diff[i][j]++;
                        }
                    }
                    flag = true;
                }
            }
        }

        // 실제로 빙산을 녹여주는데 음수가 되지 않게 조절(굳이 안해도 되긴 함)
        for(int i=1 ; i<N-1 ; i++){
            for(int j=1 ; j<M-1 ; j++){
                map[i][j] = Math.max(map[i][j] - diff[i][j], 0);
            }
        }

        return flag;
    }

    private static void BFS(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && (map[nr][nc]>0)){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }

}
