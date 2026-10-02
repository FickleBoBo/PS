package day_29.BOJ_G4_17141;

import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;
    static int wallCnt = 0;

    static List<Integer> list;
    static int R;
    static int[] sel;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        list = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    wallCnt++;
                }
                else if(map[i][j] == 2){
                    list.add(i * N + j);
                }
            }
        }

        R = M;
        sel = new int[R];
        combination(0, 0);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    private static void combination(int idx, int sidx){
        if(sidx == R){
            ans = Math.min(ans, BFS(sel));
            return;
        }

        for(int i=idx ; i<list.size() ; i++){
            sel[sidx] = list.get(i);
            combination(i+1, sidx+1);
        }
    }

    private static int BFS(int[] selected){
        int[][] copyMap = map.clone();
        for(int i=0 ; i<N ; i++){
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0 ; i<R ; i++){
            int r = selected[i] / N;
            int c = selected[i] % N;
            q.offer(new int[]{r, c});
            copyMap[r][c] = 3;
        }

        int time = 0;
        int cnt = wallCnt + R;
        while(!q.isEmpty()){
            time++;
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int[] item = q.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];
                    if(nr>=0 && nr<N && nc>=0 && nc<N && (copyMap[nr][nc]==0 || copyMap[nr][nc]==2)){
                        q.offer(new int[]{nr, nc});
                        copyMap[nr][nc] = 3;
                        cnt++;
                    }
                }
            }
        }

        if(cnt == N*N) return time-1;
        else return Integer.MAX_VALUE;
    }

}
