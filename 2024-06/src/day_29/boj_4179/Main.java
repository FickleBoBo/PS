package day_29.BOJ_G3_4179;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int H;
    static int W;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[] person = new int[2];    // 지훈이의 위치
        Queue<int[]> fire = new ArrayDeque<>();    // 불들의 위치

        map = new char[H][W];
        for(int i=0 ; i<H ; i++){
            String input = br.readLine();

            for(int j=0 ; j<W ; j++){
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'J'){
                    person[0] = i;
                    person[1] = j;
                }
                else if(map[i][j] == 'F'){
                    fire.offer(new int[]{i, j});
                }
            }
        }

        int ans = BFS(person, fire);
        System.out.println(ans > 0 ? ans : "IMPOSSIBLE");
    }

    private static int BFS(int[] person, Queue<int[]> fire){
        Queue<int[]> personQueue = new ArrayDeque<>();    // 지훈이의 위치를 담음
        personQueue.offer(person);

        Queue<int[]> fireQueue = new ArrayDeque<>(fire);    // 불의 위치를 담음

        int dist = 1;    // 최단 거리

        while(!personQueue.isEmpty()){    // 지훈이가 없어질 때까지 반복

            // 불이 붙으려는 칸으로 이동이 불가능해서 불이 먼저 이동해야 한다
            int fireLen = fireQueue.size();

            for(int i=0 ; i<fireLen ; i++){
                int[] node = fireQueue.poll();

                for(int dir=0 ; dir<4 ; dir++){
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if(nr>=0 && nr<H && nc>=0 && nc<W && (map[nr][nc]=='.' || map[nr][nc]=='J')){
                        fireQueue.offer(new int[]{nr, nc});
                        map[nr][nc] = 'F';
                    }
                }
            }

            // 이후 지훈이가 이동
            int personLen = personQueue.size();

            for(int i=0 ; i<personLen ; i++){
                int[] node = personQueue.poll();
                if((node[0]==0) || (node[0]==H-1) || (node[1]==0) || (node[1]==W-1)) return dist;

                for(int dir=0 ; dir<4 ; dir++){
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]=='.'){
                        personQueue.offer(new int[]{nr, nc});
                        map[nr][nc] = 'J';
                    }
                }
            }

            dist++;
        }

        return -1;
    }

}
