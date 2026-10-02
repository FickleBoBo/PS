package day_04.BOJ_G4_4179;

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
    static int R;
    static int C;
    static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for(int i=0 ; i<R ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int pos = -1;
        List<Integer> fire = new ArrayList<>();

        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                if(map[i][j]=='J'){
                    pos = i*C+j;
                }
                else if(map[i][j]=='F'){
                    fire.add(i*C+j);
                }
            }
        }

        int ans = BFS(pos, fire);
        if(ans > 0) System.out.println(ans);
        else System.out.println("IMPOSSIBLE");

        br.close();
    }

    private static int BFS(int pos, List<Integer> fire){
        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(pos);
        Queue<Integer> q2 = new LinkedList<>(fire);

        int ans = 1;
        while(!q1.isEmpty()){
            int len2 = q2.size();
            for(int i=0 ; i<len2 ; i++){
                int item = q2.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item/C + dr[dir];
                    int nc = item%C + dc[dir];
//                    System.out.println(nr + " " + nc);
                    if(nr>=0 && nr<R && nc>=0 && nc<C && ((map[nr][nc]=='.') || (map[nr][nc]=='J'))){
                        map[nr][nc] = 'F';
                        q2.offer(nr*C+nc);
                    }
                }
            }

//            printMap();

            int len1 = q1.size();
            for(int i=0 ; i<len1 ; i++){
                int item = q1.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item/C + dr[dir];
                    int nc = item%C + dc[dir];
                    if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]=='.'){
                        map[nr][nc] = 'J';
                        q1.offer(nr*C+nc);
                    }
                    if(nr<0 || nr==R || nc<0 || nc==C){
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
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
