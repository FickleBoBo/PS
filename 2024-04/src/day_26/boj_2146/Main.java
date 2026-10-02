package day_26.BOJ_G3_2146;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1){
                    ans = Math.min(ans, BFS(i, j));
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }

    private static int BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited = new boolean[N][N];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        int cnt = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                cnt++;
            }
        }
        if(cnt==0) return Integer.MAX_VALUE;

        q.offer(new int[]{r, c});
        int ans = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] node = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                        if(map[nr][nc] == 0){
                            q.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                        else{
                            return ans;
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }

}