package day_30.BOJ_G4_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new String[12][6];
        for(int i=0 ; i<12 ; i++){
            map[i] = br.readLine().split("");
        }

        int cnt = 0;
        while(true){
            boolean flag = false;
            for(int i=11 ; i>=0 ; i--){
                for(int j=0 ; j<6 ; j++){
                    if(!map[i][j].equals(".")){
                        boolean tmpFlag = BFS(i, j, map[i][j]);
                        if(tmpFlag){
                            flag = true;
                        }
                    }
                }
            }
            if(flag){
                dropPuyoPuyo();
                cnt++;
                continue;
            }
            break;
        }

        System.out.println(cnt);
    }

    private static void printMap(){
        for(int i=0 ; i<12 ; i++){
            for(int j=0 ; j<6 ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dropPuyoPuyo(){
        for(int j=0 ; j<6 ; j++){
            out:
            for(int i=11 ; i>0 ; i--){
                if(map[i][j].equals(".")){
                    for(int k=1 ; k<=i ; k++){
                        if(!map[i-k][j].equals(".")){
                            String tmp = map[i][j];
                            map[i][j] = map[i-k][j];
                            map[i-k][j] = tmp;
                            continue out;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static boolean BFS(int r, int c, String color){
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        int cnt = 0;

        q.offer(new int[]{r, c});
        visited[r][c] = true;
        cnt++;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(nr>=0 && nr<12 && nc>=0 && nc<6 && !visited[nr][nc] && map[nr][nc].equals(color)){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }

        if(cnt >= 4){
            flag = true;
            for(int i=0 ; i<12 ; i++){
                for(int j=0 ; j<6 ; j++){
                    if(visited[i][j]){
                        map[i][j] = ".";
                    }
                }
            }
        }

        return flag;
    }

}
