package day_30.BOJ_G1_4991_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0 ,1, 0, -1};

    static int w;
    static int h;
    static String[][] map;
    static List<int[]> dirtyPosList;
    static int[][] adj;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            dirtyPosList = new ArrayList<>();
            ans = 0;
            int r = -1;
            int c = -1;
            map = new String[h][w];
            for(int i=0 ; i<h ; i++){
                map[i] = br.readLine().split("");
                for(int j=0 ; j<w ; j++){
                    if(map[i][j].equals("*")){
                        dirtyPosList.add(new int[]{i, j});
                    }
                    else if(map[i][j].equals("o")){
                        r = i;
                        c = j;
                    }
                }
            }
            adj = new int[1+dirtyPosList.size()][1+dirtyPosList.size()];

            BFS(r, c);
            for(int[] pos : dirtyPosList){
                BFS(pos[0], pos[1]);
            }



        }
    }

    private static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int path = 0;
        while(!q.isEmpty()){
            path++;
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int[] item = q.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];
                    if(nr>=0 && nr<h && nc>=0 && nc<w && !visited[nr][nc] && !map[nr][nc].equals("x")){
                        if(map[nr][nc].equals("*")){
//                            adj[][] = adj[][] = path;
                        }
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        map[r][c] = ".";
    }

}
