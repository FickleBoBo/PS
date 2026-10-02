package day_24.BOJ_S1_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> ansList = new LinkedList<>();

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(map[i][j] == '1'){
                    ansList.add(BFS(i, j));
                }
            }
        }

        Collections.sort(ansList);

        System.out.println(ansList.size());
        for(int ans : ansList){
            System.out.println(ans);
        }

        br.close();
    }

    private static int BFS(int r, int c){
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        cnt++;
        map[r][c] = '0';

        while(!queue.isEmpty()){
            int[] item = queue.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && (map[nr][nc]=='1')){
                    queue.offer(new int[]{nr, nc});
                    cnt++;
                    map[nr][nc] = '0';
                }
            }
        }
        return cnt;
    }

}
