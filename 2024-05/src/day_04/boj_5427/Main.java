package day_04.BOJ_G4_5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int h;
    static int w;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            map = new String[h][w];
            for(int i=0 ; i<h ; i++){
                map[i] = br.readLine().split("");
            }

            int[] pos = new int[2];
            List<int[]> fire = new ArrayList<>();

            for(int i=0 ; i<h ; i++){
                for(int j=0 ; j<w ; j++){
                    if(map[i][j].equals("@")){
                        pos[0] = i;
                        pos[1] = j;
                    }
                    else if(map[i][j].equals("*")){
                        fire.add(new int[]{i, j});
                    }
                }
            }

            int ans = BFS(pos, fire);

            if(ans > 0) System.out.println(ans);
            else System.out.println("IMPOSSIBLE");
        }
        br.close();
    }

    private static int BFS(int[] pos, List<int[]> fire){
        Queue<int[]> q1 = new LinkedList<>();
        q1.offer(pos);
        Queue<int[]> q2 = new LinkedList<>(fire);

        int ans = 1;
        while(!q1.isEmpty()){

//            printMap();



//            printMap();

            int len2 = q2.size();
            for(int i=0 ; i<len2 ; i++){
                int[] item = q2.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];
                    if(nr>=0 && nr<h && nc>=0 && nc<w && (map[nr][nc].equals(".") || map[nr][nc].equals("@"))){
                        map[nr][nc] = "*";
                        q2.offer(new int[]{nr, nc});
                    }
                }
            }

            int len1 = q1.size();
            for(int i=0 ; i<len1 ; i++){
                int[] item = q1.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];
                    if(nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc].equals(".")){
                        map[nr][nc] = "@";
                        q1.offer(new int[]{nr, nc});
                    }
                    else if(nr<0 || nr==h || nc<0 || nc==w){
                        return ans;
                    }
                }
            }

//            printMap();

            ans++;

        }
        return 0;
    }

    private static void printMap(){
        for(int i=0 ; i<h ; i++){
            for(int j=0 ; j<w ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
